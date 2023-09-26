package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.AbstractPanel
import model.randomizer.Randomize

class EncounterPanel extends AbstractPanel {
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = {
    var wildUnit = new Randomize().randomUnit()
    // TODO: Combat goes here.
  }
}
