package cl.uchile.dcc.citric
package controller.states

import model.entities.{Player, WildUnit}
import model.panels.Panel

/**
 *
 */
trait GameState {
  def getStateName: String
  def doAction(): Unit
  def startGame(): Unit
  def newGame(): Unit
  def startTurn(player: Player): Unit
  def endCombat(): Unit
  def startPlayerCombat(player: Player): Unit
  def startWildUnitCombat(wildUnit: WildUnit): Unit
  def landOnPanel(panel: Panel): Unit
  def startRecovery(): Unit
  def passRecovery(): Unit
  def failRecovery(): Unit

  def rollDie(): Unit
  def endTurn(): Unit
}
