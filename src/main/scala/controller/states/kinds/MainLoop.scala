package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

/** The main loop of the game. Controls starting Players' turns.
 *
 * @param controller The controller this state belongs to.
 */
class MainLoop(controller: GameController) extends AbstractGameState("MainLoop", controller) {
  override def startTurn(player: Player): Unit = {
    context.setState(new PlayerTurn(context, player))
  }
}
