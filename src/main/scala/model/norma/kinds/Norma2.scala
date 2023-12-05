package cl.uchile.dcc.citric
package model.norma.kinds

import model.entities.Player
import model.norma.{AbstractNorma, Norma}

/** A concrete implementation of a `Norma` with level 2
 *
 * @param goalType The type of goal towards clearing to the next level.
 */
class Norma2(goalType: String, player: Player) extends AbstractNorma(2, goalType, player) {
  override def next(nextGoalType: => String): Norma = new Norma3(nextGoalType, player)
}
