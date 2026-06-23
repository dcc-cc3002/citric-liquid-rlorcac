package cl.uchile.dcc.citric
package model.norma

/** A general representation of player's Norma
 *
 */
trait Norma {
  /**
   *
   * @return The current goal
   */
  def goal: (Int, String)

  /**
   *
   * @return The current norma level of this object
   */
  def level: Int

  /** Applies norma check with current stars and victories
   *
   * @param stars The player's current amount of stars
   * @param victories The player's current amount of victories
   * @return Norma object with level incremented by 1 if check passes, this if check fails.
   */
  def check(stars: Int, victories: Int): Norma

}
