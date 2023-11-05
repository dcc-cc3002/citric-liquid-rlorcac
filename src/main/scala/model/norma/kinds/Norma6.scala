package cl.uchile.dcc.citric
package model.norma.kinds

import model.norma.{AbstractNorma, Norma}

/** A concrete implementation of a `Norma` with level 6
 *
 * @param goalType The type of goal towards clearing to the next level.
 */
class Norma6(goalType: String) extends AbstractNorma(6, goalType) {
  override def next(nextGoalType: => String): Norma = this
}
