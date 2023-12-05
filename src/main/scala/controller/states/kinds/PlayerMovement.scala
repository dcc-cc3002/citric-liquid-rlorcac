package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

class PlayerMovement(controller: GameController, player: Player) extends AbstractGameState("PlayerMovement", controller) {
  move(player.rollDice())
  private def move(movementAmount: Int): Unit = {
    var currentPanel = player.currentPanel
    for(i <- 1 to movementAmount){
      val nextPanels = currentPanel.nextPanels
      if(nextPanels.size == 1){
        currentPanel = nextPanels(0)
      }
      else{
        currentPanel = nextPanels(context.getInput(nextPanels.map(panel => panel.name).toList))
      }
    }
  }
}
