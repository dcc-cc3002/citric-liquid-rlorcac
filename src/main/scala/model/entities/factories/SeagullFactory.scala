package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.{ConcreteWildUnit, WildUnit}
import model.factories.Factory

/** A factory for Seagull entities. Creates Seagulls with the same attributes every time.
 *
 */
class SeagullFactory extends Factory[WildUnit] {
  override def create(): WildUnit = new ConcreteWildUnit(3, +1, -1, -1, 2)
}
