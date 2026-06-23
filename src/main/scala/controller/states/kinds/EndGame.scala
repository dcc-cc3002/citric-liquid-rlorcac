package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState

/** A state representing the end of the game.
 *
 * @param controller The controller that this end-state belongs to.
 */
class EndGame(controller: GameController) extends AbstractGameState("EndGame", controller) {
  override def newGame(): Unit = context.setState(new PreGame(context))
}
