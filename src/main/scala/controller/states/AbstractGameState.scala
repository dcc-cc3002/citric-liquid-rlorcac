package cl.uchile.dcc.citric
package controller.states

import controller.GameController
import exceptions.InvalidStateTransitionException
import model.entities.Player

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

  override def landOnPanel(): Unit = invalidTransition("PlayerPanel")

  override def startRecovery(): Unit = invalidTransition("Recovery")

  override def passRecovery(): Unit = invalidTransition("PlayerTurn")

  override def failRecovery(): Unit = invalidTransition("MainLoop")

  override def checkNorma6(): Unit = invalidTransition("EndGame")

  override def rollDie(): Unit = invalidTransition("PlayerMovement")

  override def endTurn(): Unit = invalidTransition("MainLoop")
}
