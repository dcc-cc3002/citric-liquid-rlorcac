package cl.uchile.dcc.citric
package controller.states

import controller.GameController
import exceptions.InvalidStateTransitionException
import model.entities.Player
import model.panels.Panel

abstract class AbstractGameState(protected val stateName: String,
                                 protected val context: GameController
                                ) extends GameState {

  override def getStateName: String = stateName

  private def invalidTransition(nextState: String) = throw new InvalidStateTransitionException(getStateName, nextState)

  override def startGame(): Unit = invalidTransition("MainLoop")

  override def newGame(): Unit = invalidTransition("PreGame")

  override def startTurn(player: Player): Unit = invalidTransition("PlayerTurn")

  override def endCombat(): Unit = invalidTransition("MainLoop")

  override def startCombat(): Unit = invalidTransition("Combat")

  override def landOnPanel(player: Player, panel: Panel): Unit = invalidTransition("PlayerPanel")

  override def startRecovery(player: Player): Unit = invalidTransition("Recovery")

  override def recoveryCheck(player: Player): Unit = invalidTransition("PlayerTurn | MainLoop")

  override def checkNorma6(playerList: List[Player]): Unit = invalidTransition("EndGame")

  override def rollDie(player: Player): Unit = invalidTransition("PlayerMovement")

  override def checkIfEnemyOnPanel(player: Player, panel: Panel): Unit = invalidTransition("Combat | MainLoop")

  override def checkIfKO(): Boolean = invalidTransition("Recovery | PlayerMovement")
}
