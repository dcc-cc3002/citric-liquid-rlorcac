package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

/** A state for controlling a player's turn, rolling dice, and gaining stars at the start of each turn.
 *
 * @param controller The controller this state belongs to.
 * @param player The player that is starting their turn.
 */
class PlayerTurn(controller: GameController, player: Player) extends AbstractGameState("PlayerTurn", controller) {
  player.startTurn(context.chapter)
  override def startRecovery(): Unit = {
    context.setState(new Recovery(context, player))
  }

  override def rollDie(): Unit = {
    context.setState(new PlayerMovement(controller, player))
  }
}
