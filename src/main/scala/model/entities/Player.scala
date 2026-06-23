package cl.uchile.dcc.citric
package model.entities

import model.panels.Panel

/** A representation of a Player, including things exclusive to Players. Should be used as a type instead of PlayerCharacter
 *
 */
trait Player extends Entity {

  /** Changes the player's current panel.
   *
   * @param panel The new panel the `Player` is on.
   */
  def setPanel(panel: Panel): Unit

  /**
   *
   * @return The panel the player is currently on.
   */
  def currentPanel: Panel

  /** Makes the player roll a check to recover from being KO.
   *
   * @param difficulty The minimum value for passing the recovery check.
   * @return Whether the roll passed or not.
   */
  def rollRecovery(difficulty: Int): Boolean

  /** The name of the player. This is an identifier and should be unique.
   *
   * @return The name of the player.
   */
  def name: String
  /** Adds victories to the `PlayerCharacter`'s counter
   *
   * @param amount The amount of victories to add
   */
  def addVictories(amount: Int): Unit

  /**
   *
   * @return The current norma level for the `PlayerCharacter`
   */
  def norma: Int

  /**
   *
   * @return The current count of victories for the `PlayerCharacter`
   */
  def victories: Int

  /** Handles logic for Norma Check
   *
   * @param nextLevelGoal The goal type to be used for reaching the next level
   */
  def normaCheck(nextLevelGoal: => String): Unit

  /**
   *
   * @return Returns the `Player`'s current goal in s"${goalType}, ${goalAmount}" format
   */
  def getGoal: String

  /** This should be delegated to the controller. Currently just returns default, but later should call a function on the controller.
   *
   * @param default The value to default to if no valid player input is provided.
   * @return The goal type set for the next level
   */
  def setGoal(default: String): String

  /** Causes the player to win the game by signalling its controller that it has reached norma 6.
   *
   */
  def winGame(): Unit
}
