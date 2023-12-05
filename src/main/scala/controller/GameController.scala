package cl.uchile.dcc.citric
package controller

import controller.states.GameState
import controller.states.kinds.PreGame
import model.entities.Player

import scala.util.Random

class GameController(private var players: List[Player]) {
  players = Random.shuffle(players)
  private var _chapter: Int = 1
  var state: GameState = new PreGame(this)

  def chapter: Int = _chapter

  def startGame(): Unit = {
    state.startGame()
  }

  protected[controller] def setState(newState: GameState): Unit = {
    state = newState
  }

  private def playerTurn(player: Player): Unit = {
    state.startTurn(player)
    if(player.currentHp == 0){
      state.startRecovery()
      state.doAction()
    }
    if(player.currentHp == 0){
      state.failRecovery()
    }
    else{
      state.rollDie()
      if (player.currentPanel.getWildUnit.nonEmpty) {
        state.startWildUnitCombat(player.currentPanel.getWildUnit.get)
      }
    }
  }

  def turn(): Unit = {
    for(player <- players){
      playerTurn(player)
    }
    _chapter += 1
  }
}
