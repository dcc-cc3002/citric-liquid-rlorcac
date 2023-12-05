package cl.uchile.dcc.citric
package controller.states

import controller.GameController
import exceptions.InvalidStateTransitionException
import model.entities.{Player, WildUnit}
import model.panels.Panel

abstract class AbstractGameState(protected val stateName: String,
                                 protected val context: GameController
                                ) extends GameState {

  override def doAction(): Unit = {}

  override def getStateName: String = stateName

  private def invalidTransition(nextState: String) = throw new InvalidStateTransitionException(getStateName, nextState)

  override def startGame(): Unit = invalidTransition("MainLoop")

  override def newGame(): Unit = invalidTransition("PreGame")

  override def startTurn(player: Player): Unit = invalidTransition("PlayerTurn")

  override def endCombat(): Unit = invalidTransition("MainLoop")

  override def startPlayerCombat(player: Player): Unit = invalidTransition("Combat")

  override def startWildUnitCombat(wildUnit: WildUnit): Unit = invalidTransition("Combat")

  override def landOnPanel(panel: Panel): Unit = invalidTransition("PlayerPanel")

  override def startRecovery(): Unit = invalidTransition("Recovery")

  override def passRecovery(): Unit = invalidTransition("PlayerTurn")

  override def failRecovery(): Unit = invalidTransition("MainLoop")

  override def rollDie(): Unit = invalidTransition("PlayerMovement")

  override def endTurn(): Unit = invalidTransition("MainLoop")
}
