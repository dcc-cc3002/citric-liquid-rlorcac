package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState

class PreGame(controller: GameController) extends AbstractGameState("PreGame", controller){
  override def startGame(): Unit = {
    context.setState(new MainLoop(context))
  }
}
