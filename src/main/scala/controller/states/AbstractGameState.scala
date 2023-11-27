package cl.uchile.dcc.citric
package controller.states

import exceptions.InvalidStateTransitionException
import model.entities.Player
import model.panels.Panel

import controller.GameController

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

  override def startRecovery(): Unit = invalidTransition("Recovery")

  override def recoveryCheck(): Unit = invalidTransition("PlayerTurn | MainLoop")

  override def checkNorma6(): Unit = invalidTransition("EndGame")

  override def rollDie(): Unit = invalidTransition("PlayerMovement")

  override def checkIfEnemyOnPanel(player: Player, panel: Panel): Unit = invalidTransition("Combat | MainLoop")

  override def checkIfKO(player: Player): Unit = invalidTransition("Recovery | PlayerMovement")
}
