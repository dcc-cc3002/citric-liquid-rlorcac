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
  private val wildUnitList: List[WildUnit] = List(new RoboBall(), new Seagull(), new Chicken())
  private val panelList: List[Panel] = List(new BonusPanel(), new DropPanel(), new EncounterPanel(), new NeutralPanel())
  /** Generates a random `WildUnit`
   *
   * @return A new, completely random `WildUnit`. TODO: make it choose from the list of known `WildUnit` types
   */
  def randomUnit(): WildUnit = wildUnitList(rng.nextInt(wildUnitList.length))

  /** Generates a random `Panel`
   *
   * @return
   */
  def randomPanel(): Panel = panelList(rng.nextInt(panelList.length))

  /**
   *
   * @return A list containing all `WildUnit`s this object can return via `randomUnit()`
   */
  def getWildUnitList: List[WildUnit] = wildUnitList

  /**
   *
   * @return A list containing all `Panel`s this object can return via `randomPanel()`
   */
  def getPanelList: List[Panel] = panelList
}
