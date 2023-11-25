package cl.uchile.dcc.citric
package controller.states

import model.panels.Panel

import model.entities.Player

trait GameState {
  protected def getStateName: String

  def doNext(): Unit
  def startGame(): Unit
  def newGame(): Unit
  def startTurn(): Unit
  def endCombat(): Unit
  def startCombat(): Unit
  def landOnPanel(player: Player, panel: Panel): Unit
  def startRecovery(): Unit
  def recoveryCheck(): Unit
  def checkNorma6(): Unit
  def rollDie(): Unit
  def checkIfEnemyOnPanel(player: Player, panel: Panel): Unit
  def checkIfKO(player: Player): Unit
}
