package cl.uchile.dcc.citric
package model.randomizer

import model.entities.{AbstractEntity, WildUnit}
import cl.uchile.dcc.citric.model.entities.defaultEntities.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.panels.panelKinds.{BonusPanel, DropPanel, EncounterPanel, NeutralPanel}
import cl.uchile.dcc.citric.model.panels.Panel

import scala.util.Random

/** Handles randomness while choosing types of `Panel`s, `WildUnit`s, etc.
 *
 */
class Randomize {
  private var rng = new Random()

  /** Generates a random `WildUnit`
   *
   * @return A new, completely random `WildUnit`. TODO: make it choose from the list of known `WildUnit` types
   */
  def randomUnit(): WildUnit = {
    var wildUnitList: List[WildUnit] = List(new RoboBall(), new Seagull(), new Chicken())
    wildUnitList(rng.nextInt(wildUnitList.length))
  }

  /** Generates a random `Panel`
   *
   * @return
   */
  def randomPanel(): Panel = {
    var panelList: List[Panel] = List(new BonusPanel(), new DropPanel(), new EncounterPanel(), new NeutralPanel())
    panelList(rng.nextInt(panelList.length))
  }
}
