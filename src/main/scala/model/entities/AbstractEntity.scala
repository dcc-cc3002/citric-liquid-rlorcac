package cl.uchile.dcc.citric
package model.entities

abstract class AbstractEntity(val maxHp: Int,
                     val attack: Int,
                     val defense: Int,
                     val evasion: Int) extends Entity {
  protected var currentHp: Int = maxHp
  def getCurrentHp: Int = currentHp

}
