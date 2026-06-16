package cl.uchile.dcc.citric
package controller

import controller.states.GameState
import controller.states.kinds.PreGame

class GameController {
  var chapter: Int = 1
  var state: GameState = new PreGame(this)

  def setState(newState: GameState): Unit = {
    state = newState
  }
}
