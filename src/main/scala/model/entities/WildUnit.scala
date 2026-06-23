package cl.uchile.dcc.citric
package model.entities

class WildUnit(maxHp: Int,
               attack: Int,
               defense: Int,
               evasion: Int,
               var stars: Int = 0) extends AbstractEntity(maxHp, attack, defense, evasion) {
  /** Called when the unit starts its turn
   *
   *  For a WildUnit, this method does nothing.
   */
  def startTurn(): Unit = {
  }
}
