package cl.uchile.dcc.citric
package controller.states

import model.entities.Player

trait GameState {
  protected def getStateName: String

  def startGame(): Unit
  def newGame(): Unit
  def startTurn(player: Player): Unit
  def endCombat(): Unit
  def startCombat(): Unit
  def landOnPanel(): Unit
  def startRecovery(): Unit
  def recoveryCheck(): Unit
  def checkNorma6(): Unit
  def rollDie(): Unit
  def checkIfEnemyOnPanel(): Unit
  def checkIfKO(): Boolean
}
