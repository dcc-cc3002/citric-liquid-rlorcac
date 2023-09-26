package cl.uchile.dcc.citric
package model.entities

abstract class AbstractEntity(val maxHp: Int,
                              val attack: Int,
                              val defense: Int,
                              val evasion: Int,
                              protected var stars: Int) extends Entity {
  protected var currentHp: Int = maxHp
  def getCurrentHp: Int = currentHp
  def getStars: Int = stars

  def addStars(amount: Int): Int = {
    val originalStars: Int = stars
    stars = stars + amount
    stars - originalStars
  }

  def addHp(dHp:  Int): Int = {
    val originalHp = currentHp
    currentHp = maxHp.min(currentHp + dHp)
    currentHp - originalHp
  }


  def deductStars(amount: Int): Int = {
    val originalStars: Int = stars
    stars = 0.max(stars - amount)
    originalStars - stars
  }

  def deductHp(dHp: Int): Int = {
    val originalHp: Int = currentHp
    currentHp = 0.max(currentHp - dHp)
    originalHp - currentHp
  }
}
