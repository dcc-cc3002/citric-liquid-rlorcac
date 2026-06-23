package cl.uchile.dcc.citric
package model.norma.kinds

import model.entities.Player
import model.norma.{AbstractNorma, Norma}

/** A concrete implementation of a `Norma` with level 5
 *
 * @param goalType The type of goal towards clearing to the next level.
 */
class Norma5(goalType: String, player: Player) extends AbstractNorma(5, goalType, player) {
  override def next(nextGoalType: => String): Norma = new Norma6(nextGoalType, player)
}
