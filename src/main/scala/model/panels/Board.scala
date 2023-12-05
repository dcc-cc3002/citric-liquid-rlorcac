package cl.uchile.dcc.citric
package model.panels

import model.entities.Player
import model.panels.kinds.{HomePanel, NeutralPanel}
import model.randomizer.RandomPanelFactory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/** A representation of the game's board, containing multiple Panels.
 *
 * @param players A list of players that will play on the board. Used for creating Home Panels.
 * @param size The size of the board. Actual size will be `1.max(size) + players.size` as `players.size` Home Panels will be added.
 */
class Board(players: List[Player], size: Int) {
  private val homePanels: List[HomePanel] = players.map(player => new HomePanel(player, players.indexOf(player)))
  private val panelFactory = new RandomPanelFactory()
  val panels: ArrayBuffer[Panel] = ArrayBuffer.range(0, 1.max(size)).map(_ => panelFactory.create())
  panels(0) = new NeutralPanel(0)
  private val startingPanel: Panel = panels(0)
  for(i <- panels.indices){
    panels(i).addNextPanel(panels(i+1 % panels.size)) // makes a loop out of the panels
  }
  for(homePanel <- homePanels){
    panels(Random.nextInt(panels.size)).addNextPanel(homePanel)
    homePanel.addNextPanel(panels(Random.nextInt(panels.size)))
    panels.append(homePanel)
  }
  for(player <- players){
    startingPanel.addCharacter(player)
  }

  def boardSize: Int = panels.size
}
