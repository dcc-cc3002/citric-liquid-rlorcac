package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.kinds.Seagull
import utils.factories.Factory

/** A factory for Seagull entities. Creates Seagulls with the same attributes every time.
 *
 */
class SeagullFactory extends Factory[Seagull] {
  override def create(): Seagull = new Seagull()
}
