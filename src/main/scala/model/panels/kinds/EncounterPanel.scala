package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.{Player, WildUnit}
import model.panels.AbstractPanel
import model.randomizer.RandomWildUnitFactory

import scala.util.Random

/** Represents a panel where players fight a wild unit upon landing.
 *
 */
class EncounterPanel extends AbstractPanel {
  private var wildUnit: Option[WildUnit] = None
  private val wildUnitFactory: RandomWildUnitFactory = new RandomWildUnitFactory(new Random())
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: Player): Unit = {
    if(wildUnit.isEmpty){
      wildUnit = Some(wildUnitFactory.create())
    }
  }

  def getCurrentUnit: Option[WildUnit] = wildUnit
}
