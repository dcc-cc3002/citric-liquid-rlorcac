package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

class PlayerTurn(controller: GameController, player: Player) extends AbstractGameState("PlayerTurn", controller) {
  override def startRecovery(player: Player): Unit = {
    context.setState(new Recovery(context, player))
  }
}
