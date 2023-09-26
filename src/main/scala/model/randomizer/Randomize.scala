package cl.uchile.dcc.citric
package model.randomizer

import model.entities.WildUnit
import model.entities.defaultEntities.{Chicken, RoboBall, Seagull}

import model.panels.panelKinds.{BonusPanel, DropPanel, EncounterPanel, NeutralPanel}
import model.panels.Panel

import scala.util.Random

/** Handles randomness while choosing types of `Panel`s, `WildUnit`s, etc.
 *
 */
class Randomize(private val rng: Random = new Random()) {
  /** Generates a random `WildUnit`
   *
   * @return A new, completely random `WildUnit`.
   */
  def randomUnit(): WildUnit = getWildUnitList(rng.nextInt(getWildUnitList.length))

  /** Generates a random `Panel`
   *
   * @return
   */
  def randomPanel(): Panel = getPanelList(rng.nextInt(getPanelList.length))

  /**
   *
   * @return A list containing all `WildUnit`s this object can return via `randomUnit()`
   */
  def getWildUnitList: List[WildUnit] = List(new RoboBall(), new Seagull(), new Chicken())

  /**
   *
   * @return A list containing all `Panel`s this object can return via `randomPanel()`
   */
  def getPanelList: List[Panel] = List(new BonusPanel(), new DropPanel(), new EncounterPanel(), new NeutralPanel())
}
