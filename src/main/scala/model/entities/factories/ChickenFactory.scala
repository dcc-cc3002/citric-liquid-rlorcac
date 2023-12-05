package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.kinds.Chicken
import model.factories.Factory

/** A factory for Chicken entities. Creates Chickens with the same attributes every time.
 *
 */
class ChickenFactory extends Factory[Chicken] {
  override def create(): Chicken = new Chicken()
}
