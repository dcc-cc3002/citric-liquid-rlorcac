package cl.uchile.dcc.citric
package model.norma

/** A general representation of player's Norma level and goal to reach next level
 *
 */
trait Norma {

  /**
   *
   * @return The current goal in s"${_goalType}, ${_goalAmount}" format
   */
  def goal: String

  /**
   *
   * @return The current norma level of this object
   */
  def level: Int

  /** Applies norma check with current stars and victories
   *
   * @param stars The player's current amount of stars
   * @param victories The player's current amount of victories.
   * @param nextGoalType The goal type for the player's next norma level. Valid values: "Victories" | "Stars". May be passed as a function via the controller.
   * @return Norma object with level incremented by 1 if check passes, current object if check fails.
   */
  def check(stars: Int, victories: Int, nextGoalType: => String): Norma


}
