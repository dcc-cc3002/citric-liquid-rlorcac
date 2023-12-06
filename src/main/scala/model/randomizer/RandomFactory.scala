package cl.uchile.dcc.citric
package model.randomizer

import utils.factories.Factory

import scala.util.Random

/** Creates objects of type T on demand, choosing from a list of factories at random and requesting one to create the object.
 *
 * @param factoryList A list of factories that can be called upon to create the object.
 * @param rng A source of randomness.
 * @tparam T The type of output the factory creates. Factory should be covariant relative to T.
 */
abstract class RandomFactory[T](val factoryList: List[Factory[T]],
                                private val rng: Random) extends Factory[T] {
  override def create(): T = factoryList(rng.nextInt(factoryList.length)).create()
}
