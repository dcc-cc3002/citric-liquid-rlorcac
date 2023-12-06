package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.Player

class PlayerCombat(controller: GameController, initiator: Player, receiver: Player) extends AbstractGameState("PlayerCombat", controller) {
  override def combatRound(): Unit = {
    if(context.getInput(List("Evade", "Defend")) == 0) receiver.evadeRoll(initiator) else receiver.defendRoll(initiator)
    if(receiver.currentHp == 0){
      initiator.defeatEnemy(receiver)
    }
    else{
      if (context.getInput(List("Evade", "Defend")) == 0) initiator.evadeRoll(receiver) else initiator.defendRoll(receiver)
      if (initiator.currentHp == 0) {
        receiver.defeatEnemy(initiator)
      }
    }
  }

  override def endCombat(): Unit = {
    context.setState(new MainLoop(context))
  }
}
