package cl.uchile.dcc.citric
package model.entities

abstract class AbstractEntity(val maxHp: Int,
                              val attack: Int,
                              val defense: Int,
                              val evasion: Int,
                              protected var stars: Int) extends Entity {
  protected var currentHp: Int = maxHp
  def getCurrentHp: Int = currentHp

  /** Adds stars to the given `Entity`'s counter
   *
   * @param amount The amount of stars to add
   */
  def addStars(amount: Int): Unit = {
    stars = stars + amount
  }

  /** Safely takes away stars from the given `Entity`'s counter until 0 is reached
   *
   * @param amount The amount of stars to take away
   */
  def deductStars(amount: Int): Unit = {
    stars = 0.max(stars - amount)
  }
}
