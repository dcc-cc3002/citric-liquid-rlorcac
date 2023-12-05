package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.{ConcreteWildUnit, WildUnit}
import model.factories.Factory

import cl.uchile.dcc.citric.model.entities.kinds.Seagull

/** A factory for Seagull entities. Creates Seagulls with the same attributes every time.
 *
 */
class SeagullFactory extends Factory[Seagull] {
  override def create(): Seagull = new Seagull()
}
