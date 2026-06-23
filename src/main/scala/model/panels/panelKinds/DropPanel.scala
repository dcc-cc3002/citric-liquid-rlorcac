package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.AbstractPanel

class DropPanel extends AbstractPanel {
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = {
    var roll: Int = player.rollDice()
    var norma: Int = player.getNorma
    player.stars -= roll * norma
  }
}
