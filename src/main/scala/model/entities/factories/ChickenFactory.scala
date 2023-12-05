package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.{ConcreteWildUnit, WildUnit}
import model.factories.Factory

/** A factory for Chicken entities. Creates Chickens with the same attributes every time.
 *
 */
class ChickenFactory extends Factory[WildUnit] {
  override def create(): WildUnit = new ConcreteWildUnit(3, -1, -1, +1, 3)
}
