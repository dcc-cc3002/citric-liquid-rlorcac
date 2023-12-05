package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

class Recovery(controller: GameController, player: Player) extends AbstractGameState("Recovery", controller){
  player.rollRecovery(1.min(6-controller.chapter))
  if(player.currentHp == 0){

  }

  override def failRecovery(): Unit = {
    context.setState(new MainLoop(controller))
  }

  override def passRecovery(): Unit = {
    context.setState(new PlayerTurn(controller, player))
  }
}
