package cl.uchile.dcc.citric
package model.entities

trait Entity {
  val maxHp: Int
  val attack: Int
  val defense: Int
  val evasion: Int
  var stars: Int

  /**
   *
   * @return Current HP of the `Entity`
   */
  def getCurrentHp: Int
  /** Called when the unit starts its turn
   *
   */
  def startTurn(): Unit
}
