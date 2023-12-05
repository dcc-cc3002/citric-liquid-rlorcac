package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.{ConcreteWildUnit, WildUnit}
import model.factories.Factory

import cl.uchile.dcc.citric.model.entities.kinds.RoboBall

/** A factory for RoboBall entities. Creates RoboBalls with the same attributes every time.
 *
 */
class RoboBallFactory extends Factory[RoboBall] {
  override def create(): RoboBall = new RoboBall()
}
