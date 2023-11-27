package cl.uchile.dcc.citric
package controller.states.kinds

import controller.states.AbstractGameState

import controller.GameController

class PreGame(controller: GameController) extends AbstractGameState("PreGame", controller){
  override def startGame(): Unit = {
    context.setState(new MainLoop(context))
  }
}
