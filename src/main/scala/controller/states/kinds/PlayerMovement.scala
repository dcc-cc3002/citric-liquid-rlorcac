package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player
import model.panels.Panel

class PlayerMovement(controller: GameController, player: Player) extends AbstractGameState("PlayerMovement", controller) {
  private val movementAmount: Int = player.rollDice()

  /** Moves player by at most a given amount of panels, and processes logic for home panels.
   *
   * @param movementAmount The maximum amount of squares to move.
   */
  private def move(movementAmount: Int): Panel = {
    var currentPanel = player.currentPanel
    currentPanel.removeCharacter(player)
    for(i <- 1 to movementAmount){
      val nextPanels = currentPanel.nextPanels
      if(nextPanels.size == 1){
        currentPanel = nextPanels(0)
      }
      else{
        currentPanel = nextPanels(context.getInput(nextPanels.map(panel => panel.name).toList))
      }
      if(controller.board.homePanels.contains(currentPanel)){
        val home = controller.board.homePanels(controller.board.homePanels.indexOf(currentPanel)) // a very stupid way to cast to HomePanel
        if(i < movementAmount & home.owner == player){
          if(controller.getInput(List("Stop", "Continue")) == 0){
            return currentPanel
          }
          else currentPanel.activate(player)
        }
        else currentPanel.activate(player)
      }
    }
    currentPanel
  }

  override def landOnPanel(): Unit = context.setState(new PlayerPanel(context, player, move(movementAmount)))
}
