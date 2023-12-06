package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState
import model.entities.{Player, WildUnit}
import model.panels.Panel

class PlayerPanel(controller: GameController, player: Player, panel: Panel) extends AbstractGameState("PlayerPanel", controller) {
  panel.addCharacter(player)

  override def endTurn(): Unit = {
    context.setState(new MainLoop(context))
  }

  override def startPlayerCombat(against: Player): Unit = {
    context.setState(new PlayerCombat(context, player, against))
  }

  override def startWildUnitCombat(wildUnit: WildUnit): Unit = {

    context.setState(new WildUnitCombat(context, player, wildUnit))
  }
}
