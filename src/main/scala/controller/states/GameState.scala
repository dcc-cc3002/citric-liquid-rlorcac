package cl.uchile.dcc.citric
package controller.states

import model.entities.{Player, WildUnit}

/** A representation of the possible logical game states that may be reached.
 *
 */
trait GameState {
  def getStateName: String

  def startGame(): Unit

  def newGame(): Unit

  def startTurn(player: Player): Unit

  def endCombat(): Unit

  def startPlayerCombat(against: Player): Unit

  def startWildUnitCombat(wildUnit: WildUnit): Unit

  def landOnPanel(): Unit

  def startRecovery(): Unit

  def passRecovery(): Unit

  def failRecovery(): Unit

  def rollDie(): Unit

  def endTurn(): Unit

  def combatRound(): Unit
}
