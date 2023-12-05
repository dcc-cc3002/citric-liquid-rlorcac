package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.{ConcreteWildUnit, WildUnit}
import model.factories.Factory

import cl.uchile.dcc.citric.model.entities.kinds.Chicken

/** A factory for Chicken entities. Creates Chickens with the same attributes every time.
 *
 */
class ChickenFactory extends Factory[Chicken] {
  override def create(): Chicken = new Chicken()
}
