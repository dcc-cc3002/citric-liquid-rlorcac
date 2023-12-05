package cl.uchile.dcc.citric
package controller.states

import model.entities.Player
import model.panels.Panel

trait GameState {
  protected def getStateName: String

  def startGame(): Unit
  def newGame(): Unit
  def startTurn(player: Player): Unit
  def endCombat(): Unit
  def startCombat(): Unit
  def landOnPanel(player: Player, panel: Panel): Unit
  def startRecovery(player: Player): Unit
  def recoveryCheck(player: Player): Unit
  def checkNorma6(playerList: List[Player]): Unit
  def rollDie(player: Player): Unit
  def checkIfEnemyOnPanel(player: Player, panel: Panel): Unit
  def checkIfKO(): Boolean
}
