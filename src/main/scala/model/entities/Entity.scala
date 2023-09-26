package cl.uchile.dcc.citric
package model.entities

trait Entity {
  val maxHp: Int
  val attack: Int
  val defense: Int
  val evasion: Int
  var stars: Int

  /** Called when the unit starts its turn
   *
   */
  def startTurn(): Unit
}
