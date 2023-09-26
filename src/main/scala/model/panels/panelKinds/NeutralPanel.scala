package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.AbstractPanel

class NeutralPanel extends AbstractPanel {
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * In the case of a `NeutralPanel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = println("Absolutely nothing happened")
}
