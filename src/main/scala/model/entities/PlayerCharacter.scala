package cl.uchile.dcc.citric
package model.entities

import model.norma.Norma
import model.norma.kinds.Norma1
import model.panels.Panel

import scala.util.Random


/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
 * several attributes such as health points, attack strength, defense capability,
 * and evasion skills. Each player has a unique name, and throughout the game,
 * players can collect stars, roll dice, and progress in levels known as 'norma'.
 * This class not only maintains the state of a player but also provides methods
 * to modify and interact with these attributes.
 *
 * For instance, players can:
 *
 * - Increase or decrease their star count.
 *
 * - Roll a dice, a common action in many board games.
 *
 * - Advance their norma level.
 *
 * Furthermore, the `Player` class has a utility for generating random numbers,
 * which is primarily used for simulating dice rolls. By default, this utility is
 * an instance of the `Random` class but can be replaced if different random
 * generation behaviors are desired.
 *
 * @param _name The name of the player. This is an identifier and should be unique.
 * @param _maxHp The maximum health points a player can have. It represents the player's endurance.
 * @param _attack The player's capability to deal damage to opponents.
 * @param _defense The player's capability to resist or mitigate damage from opponents.
 * @param _evasion The player's skill to completely avoid certain attacks.
 * @param _randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
 *                              instance.
 * @param _stars The player's starting amount of stars. Defaults to 0
 *
 *
 * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
 * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
 * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
 * @author [[https://github.com/Seivier/ Vicente González B.]]
 * @author [[https://github.com/rlorcac/ Raimundo Lorca C.]]
 */
class PlayerCharacter(protected val _name: String,
                      _maxHp: Int,
                      _attack: Int,
                      _defense: Int,
                      _evasion: Int,
                      startGoalType: => String,
                      val _randomNumberGenerator: Random = new Random(),
                      _stars: Int = 0
                     ) extends AbstractEntity(_maxHp, _attack, _defense, _evasion, _stars, _randomNumberGenerator)
  with Player {
  private var _norma: Norma = new Norma1(startGoalType)
  private var _victories: Int = 0
  private var _currentPanel: Panel = _

  override def setPanel(panel: Panel): Unit = {
    _currentPanel = panel
  }

  override def name: String = _name

  override def givesVictories: Int = 2

  override def addVictories(amount: Int): Unit = {
    if(amount >= 0) _victories = _victories + amount
  }

  override def getGoal: String = _norma.goal

  override def startTurn(chapter: Int): Unit = {
      addStars(chapter/5 + 1)
  }

  override def norma: Int = _norma.level

  override def victories: Int = _victories

  override def normaCheck(nextLevelGoal: => String): Unit = {
    _norma = _norma.check(stars, victories, nextLevelGoal)
  }

  def setGoal(default: String = "Stars"): String = {
    // TODO: Goal-setting logic from the controller.
    default
  }

  override def defeatedByPlayer(player: Player): Unit = {
    val starsToGive: Int = stars/2
    deductStars(starsToGive)
    player.addStars(starsToGive)
    player.addVictories(givesVictories)
  }

  override def defeatedByWildUnit(wildUnit: WildUnit): Unit = {
    val starsToGive: Int = stars / 2
    deductStars(starsToGive)
    wildUnit.addStars(starsToGive)
  }

  override def defeatEnemy(enemy: Entity): Unit = enemy.defeatedByPlayer(this)

  /** Makes the player roll a check to recover from being KO.
   *
   * @param difficulty The minimum value for passing the recovery check.
   */
  override def rollRecovery(difficulty: Int): Unit = {
    val roll = rollDice()
    if(roll >= difficulty){
      addHp(maxHp)
    }
  }

  override def currentPanel: Panel = _currentPanel
}
