package cl.uchile.dcc.citric
package model.entities

abstract class AbstractEntity(protected val _maxHp: Int,
                              protected val _attack: Int,
                              protected val _defense: Int,
                              protected val _evasion: Int,
                              protected var _stars: Int) extends Entity {
  private var _currentHp: Int = maxHp

  override def maxHp: Int = _maxHp

  override def attack: Int = _attack

  override def defense: Int = _defense

  override def evasion: Int = _evasion

  def currentHp: Int = _currentHp

  protected def currentHp_=(newCurrentHp: Int): Unit = {_currentHp = newCurrentHp}
  def stars: Int = stars

  def addStars(amount: Int): Int = {
    if(amount < 0) {
      return 0
    }
    val originalStars: Int = stars
    stars = stars + amount
    stars - originalStars
  }

  def addHp(dHp:  Int): Int = {
    if (dHp < 0) {
      return 0
    }
    val originalHp = currentHp
    currentHp = maxHp.min(currentHp + dHp)
    currentHp - originalHp
  }


  def deductStars(amount: Int): Int = {
    if (amount < 0) {
      return 0
    }
    val originalStars: Int = stars
    stars = 0.max(stars - amount)
    originalStars - stars
  }

  def deductHp(dHp: Int): Int = {
    if (dHp < 0) {
      return 0
    }
    val originalHp: Int = currentHp
    currentHp = 0.max(currentHp - dHp)
    originalHp - currentHp
  }
}
