package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState

class EndGame(controller: GameController) extends AbstractGameState("EndGame", controller) {
  override def newGame(): Unit = context.setState(new PreGame(context))
}
