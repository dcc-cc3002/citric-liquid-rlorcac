package cl.uchile.dcc.citric
package model.entities

import exceptions.InvalidStatException

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
  * @param name The name of the player. This is an identifier and should be unique.
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
class PlayerCharacter(val name: String,
                      _maxHp: Int,
                      _attack: Int,
                      _defense: Int,
                      _evasion: Int,
                      val _randomNumberGenerator: Random = new Random(),
                      _stars: Int = 0
                     ) extends AbstractEntity(_maxHp, _attack, _defense, _evasion, _stars, _randomNumberGenerator) {
  private var _norma: Int = 1
  private var victories: Int = 0
  private var goal: (String, Int) = _
  setGoal() // Immediately calls setGoal() to set goal for next Norma level

  /** Adds victories to the `PlayerCharacter`'s counter
   *
   * @param amount The amount of victories to add
   */
  def addVictories(amount: Int): Unit = {
    if(amount >= 0) victories = victories + amount
  }

  /** Called when the unit starts its turn
   *
   */
  override def startTurn(): Unit = {
    if (currentHp < 0) {
      throw new InvalidStatException("HP can not be lower than 0")
    }
    else if (currentHp > maxHp) {
      throw new InvalidStatException("HP can not be higher than max HP")
    }
    else if(currentHp == 0){
      // TODO: recovery
    }
    else{ // default case
      // TODO: Add star addition logic.
    }
  }

  /**
   *
   * @return The current norma level for the `PlayerCharacter`
   */
  def norma: Int = _norma

  protected def norma_=(newNorma: Int):Unit = {_norma = newNorma}

  /**
   *
   * @return The current count of victories for the `PlayerCharacter`
   */
  def getVictories: Int = victories

  /**
   *
   * @return The `PlayerCharacter`'s next Norma goal in "$amount $type" format
   */
  def getGoal: String = goal._2.toString + " " + goal._1

  /** Handles logic for checking if Norma Clear can be executed
   *
   */
  def normaCheck(): Unit = {
    val normaMap: Map[String, Int] = Map[String, Int]("Victories" -> getVictories, "Stars" -> stars)
    val goalCount: Int = goal._2
    if(normaMap(goal._1) >= goalCount){
      normaClear()
    }
  }

  /** Invoked only if the player can Norma Clear, increments `norma` by 1 and asks to set goal for next Norma level.
   *
   */
  private def normaClear(): Unit = {
    norma = norma + 1
    setGoal()
  }

  /** Asks the player to choose a goal for next Norma level.
   *
   * @param default Pair `(type, amount)` for next Norma level goal. Allowed values for `type`: "Victories", "Stars". Allowed values for `amount`: `Int`
   *
   */
  def setGoal(default: (String, Int) = ("Victories", 1)): Unit = {
    // TODO: Add goal-setting logic.
    goal = default
  }
}
