package cl.uchile.dcc.citric
package controller.states.kinds

import controller.states.AbstractGameState
import controller.GameController

import model.entities.Player

class MainLoop(controller: GameController) extends AbstractGameState("MainLoop", controller) {
  override def startTurn(player: Player): Unit = {
    player.startTurn(context.chapter)
    context.setState(new PlayerTurn(context, player))
  }
}
