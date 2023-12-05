package cl.uchile.dcc.citric
package model.randomizer

import model.entities.WildUnit
import model.entities.factories.{ChickenFactory, RoboBallFactory, SeagullFactory}
import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.{BonusPanel, DropPanel, EncounterPanel, NeutralPanel}

import scala.util.Random

/** Handles randomness while choosing types of `Panel`s, `WildUnit`s, etc.
 *
 * @param rng A source of randomness
 */
class RandomizedFactory(private val rng: Random = new Random()) {
  /** Generates a random `WildUnit`
   *
   * @return A new, completely random `WildUnit`.
   */
  def randomUnit(): WildUnit = getWildUnitFactoryList(rng.nextInt(getWildUnitFactoryList.length)).create()

  /** Generates a random `Panel`
   *
   * @return
   */
  def randomPanel(): Panel = getPanelList(rng.nextInt(getPanelList.length))

  /**
   *
   * @return A list containing all `WildUnit` Factories this object can use to create a random `WildUnit`
   */
  def getWildUnitFactoryList: List[Factory[WildUnit]] = List(new RoboBallFactory(), new SeagullFactory(), new ChickenFactory())

  /**
   *
   * @return A list containing all `Panel`s this object can return via `randomPanel()`
   */
  def getPanelList: List[Panel] = List(new BonusPanel(), new DropPanel(), new EncounterPanel(), new NeutralPanel())
}
