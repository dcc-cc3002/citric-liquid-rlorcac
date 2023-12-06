package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.{Player, WildUnit}

class WildUnitCombat(controller: GameController, initiator: Player, receiver: WildUnit) extends AbstractGameState("PlayerCombat", controller) {
  override def endCombat(): Unit = {
    context.setState(new MainLoop(context))
  }
}
