package cl.uchile.dcc.citric
package model.entities

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
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/rlorcac/ Raimundo Lorca C.]]
  */
class PlayerCharacter(val name: String,
              maxHp: Int,
              attack: Int,
              defense: Int,
              evasion: Int,
              val randomNumberGenerator: Random = new Random()) extends AbstractEntity(maxHp, attack, defense, evasion) {
  var stars: Int = 0
  private var norma: Int = 1
  var victorias: Int = 0
  var alive: Boolean = true
  var goal: (String, Int) = new Tuple2[String, Int]()

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Called when the unit starts its turn
   *
   */
  def startTurn(): Unit = {

  }

  def getNorma: Int = norma

  /** Handles logic for checking if Norma Clear can be executed
   *
   */
  def normaCheck(): Unit = {
    var conditionIsStars: Boolean = goal[0]
    var goalCount: Int = goal[1]
  }

  /** Invoked only if the player can Norma Clear, increments `norma` by 1 and asks to set goal for next Norma level.
   *
   */
  def normaClear(): Unit = {
    norma += 1
    setGoal()
  }

  /** Asks the player to choose a goal for next Norma level.
   *
   */
  private def setGoal(): Unit = {

  }

}
