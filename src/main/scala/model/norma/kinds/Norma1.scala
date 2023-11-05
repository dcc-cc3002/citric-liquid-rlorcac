package cl.uchile.dcc.citric
package model.norma.kinds

import model.norma.{AbstractNorma, Norma}

/** A concrete implementation of a `Norma` with level 1
 *
 * @param goalType The type of goal towards clearing to the next level.
 */
class Norma1(goalType: String) extends AbstractNorma(1, goalType) {
  override def next(nextGoalType: => String): Norma = new Norma2(nextGoalType)
}
