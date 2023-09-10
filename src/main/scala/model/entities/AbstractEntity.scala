package cl.uchile.dcc.citric
package model.entities

abstract class AbstractEntity(val maxHp: Int,
                     val attack: Int,
                     val defense: Int,
                     val evasion: Int) extends Entity {

}
