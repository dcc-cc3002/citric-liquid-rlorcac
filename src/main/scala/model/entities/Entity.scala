package cl.uchile.dcc.citric
package model.entities

trait Entity {
  /**
   *
   * @return Max HP of the `Entity`
   */
  def maxHp: Int

  /**
   *
   * @return ATK of the `Entity`
   */
  def attack: Int

  /**
   *
   * @return DEF of the `Entity`
   */
  def defense: Int

  /**
   *
   * @return EVA of the `Entity`
   */
  def evasion: Int

  /**
   *
   * @return Current HP of the `Entity`
   */
  def currentHp: Int

  /**
   *
   * @return Current star count of the `Entity`
   */
  def stars: Int

  /** Adds HP up to the maximum allowed HP
   *
   * @param dHp Max amount of HP to add. Must be non-negative.
   * @return Amount of HP actually added
   */
  def addHp(dHp: Int): Int

  /** Adds stars to the current star count
   *
   * @param amount Amount of stars to add. Must be non-negative.
   * @return Amount of stars actually added
   */
  def addStars(amount: Int): Int

  /** Takes away HP until 0 is reached
   *
   * @param dHp Max amount of HP to take away. Must be non-negative.
   * @return Amount of HP actually taken away
   */

  def deductHp(dHp: Int): Int


  /** Takes away stars until 0 is reached
   *
   * @param amount Max amount of stars to take away. Must be non-negative.
   * @return Amount of stars actually taken away
   */
  def deductStars(amount: Int): Int


  /** Called when the unit starts its turn
   *
   */
  def startTurn(): Unit
}
