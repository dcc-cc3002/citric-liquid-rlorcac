package cl.uchile.dcc.citric
package model.entities

class WildUnit(maxHp: Int,
               attack: Int,
               defense: Int,
               evasion: Int,
               stars: Int = 0) extends AbstractEntity(maxHp, attack, defense, evasion, stars) {
  /** Called when the unit starts its turn
   *
   *  For a WildUnit, this method does nothing.
   */
  def startTurn(): Unit = {
  }
}
