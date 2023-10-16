package cl.uchile.dcc.citric
package model.entities

/** An abstract representation of all the units in the game, covering both players and
 * wild units.
 *
 * @param _maxHp The maximum, and starting, amount of HP the `Entity` has.
 * @param _attack The `Entity`'s capability to deal damage to opponents.
 * @param _defense The `Entity`'s capability to resist or mitigate damage from opponents.
 * @param _evasion The `Entity`'s skill to completely avoid certain attacks.
 * @param _stars The `Entity`'s starting amount of stars. Defaults to 0
 */
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

  override def stars: Int = _stars

  protected def stars_=(newStars: Int): Unit = {_stars = newStars}

  override def addStars(amount: Int): Int = {
    if(amount < 0) {
      return 0
    }
    val originalStars: Int = stars
    stars = stars + amount
    stars - originalStars
  }

  override def addHp(dHp:  Int): Int = {
    if (dHp < 0) {
      return 0
    }
    val originalHp = currentHp
    currentHp = maxHp.min(currentHp + dHp)
    currentHp - originalHp
  }


  override def deductStars(amount: Int): Int = {
    if (amount < 0) {
      return 0
    }
    val originalStars: Int = stars
    stars = 0.max(stars - amount)
    originalStars - stars
  }

  override def deductHp(dHp: Int): Int = {
    if (dHp < 0) {
      return 0
    }
    val originalHp: Int = currentHp
    currentHp = 0.max(currentHp - dHp)
    originalHp - currentHp
  }

}
