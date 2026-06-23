package cl.uchile.dcc.citric
package model.entities

abstract class AbstractWildUnit(maxHp: Int,
                       attack: Int,
                       defense: Int,
                       evasion: Int,
                       stars: Int) extends AbstractEntity(maxHp, attack, defense, evasion, stars)
                       with WildUnit {
  /** Called when the unit starts its turn
   *
   *  For a WildUnit, this method does nothing.
   */
  def startTurn(): Unit = {
  }
}
