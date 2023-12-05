package cl.uchile.dcc.citric
package model.randomizer

import model.entities.WildUnit
import model.entities.factories.{ChickenFactory, RoboBallFactory, SeagullFactory}

import scala.util.Random
/** Creates `WildUnit`s on demand, choosing from the default types at random.
 *
 * @param rng A source of randomness
 */
class RandomWildUnitFactory(private val rng: Random = new Random())
  extends RandomFactory[WildUnit](
    List(new RoboBallFactory(), new SeagullFactory(), new ChickenFactory()),
    rng
  )
