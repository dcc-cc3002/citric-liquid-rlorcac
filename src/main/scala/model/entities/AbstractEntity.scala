package cl.uchile.dcc.citric
package model.entities

import controller.GameController

import scala.util.Random

/** An abstract representation of all the units in the game, covering both players and
 * wild units.
 *
 * @param _maxHp The maximum, and starting, amount of HP the `Entity` has.
 * @param _attack The `Entity`'s capability to deal damage to opponents.
 * @param _defense The `Entity`'s capability to resist or mitigate damage from opponents.
 * @param _evasion The `Entity`'s skill to completely avoid certain attacks.
 * @param _stars The `Entity`'s starting amount of stars. Defaults to 0
 * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
 *                              instance.
 */
abstract class AbstractEntity(protected val _maxHp: Int,
                              protected val _attack: Int,
                              protected val _defense: Int,
                              protected val _evasion: Int,
                              protected var _stars: Int,
                              protected val randomNumberGenerator: Random = new Random()
                             ) extends Entity {
  private var _currentHp: Int = maxHp

  private var _controller: GameController = _

  override def setController(controller: GameController): Unit = {
    _controller = controller
  }

  override def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

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

  override def attackRoll: Int = if (currentHp > 0) rollDice() + attack else 0

  override def defendRoll(attacker: Entity): Unit = {
    val atkRoll = attacker.attackRoll
    if(atkRoll == 0) return
    val defRoll = rollDice() + defense
    val subtract = 1.max(atkRoll - defRoll)
    deductHp(subtract)
  }

  override def evadeRoll(attacker: Entity): Unit = {
    val atkRoll = attacker.attackRoll
    val evaRoll = rollDice() + evasion
    val subtract = if(evaRoll > atkRoll) 0 else atkRoll
    deductHp(subtract)
  }

  override def getContext: GameController = _controller
}
