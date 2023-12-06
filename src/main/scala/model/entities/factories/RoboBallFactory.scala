package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.kinds.RoboBall
import utils.factories.Factory

/** A factory for RoboBall entities. Creates RoboBalls with the same attributes every time.
 *
 */
class RoboBallFactory extends Factory[RoboBall] {
  override def create(): RoboBall = new RoboBall()
}
