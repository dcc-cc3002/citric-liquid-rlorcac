package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

/** A state for controlling recovery for KO'd players.
 *
 * @param controller The controller this state belongs to.
 * @param player The player that needs to roll for recovery.
 */
class Recovery(controller: GameController, player: Player) extends AbstractGameState("Recovery", controller){
  player.rollRecovery(1.max(6-controller.chapter))

  override def failRecovery(): Unit = {
    context.setState(new MainLoop(controller))
  }

  override def passRecovery(): Unit = {
    context.setState(new PlayerTurn(controller, player))
  }
}
