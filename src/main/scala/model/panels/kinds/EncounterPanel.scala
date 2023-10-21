package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.{PlayerCharacter, WildUnit}
import model.panels.AbstractPanel
import model.randomizer.Randomize

/** Represents a panel where players fight a wild unit upon landing.
 *
 */
class EncounterPanel extends AbstractPanel {
  private var wildUnit: Option[WildUnit] = None
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = {
    if(wildUnit.isEmpty){
      wildUnit = Some(new Randomize().randomUnit())
    }
    // TODO: Combat goes here.
  }

  def getCurrentUnit: Option[WildUnit] = wildUnit
}
