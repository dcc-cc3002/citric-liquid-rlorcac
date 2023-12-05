package cl.uchile.dcc.citric
package model.entities

/** A representation of a general Entity, covering both players and wild units.
 *
 */
trait Entity {
  /**
   *
   * @return Max HP of the `Entity`
   */
  def maxHp: Int

  /**
   *
   * @return ATK of the `Entity`
   */
  def attack: Int

  /**
   *
   * @return DEF of the `Entity`
   */
  def defense: Int

  /**
   *
   * @return EVA of the `Entity`
   */
  def evasion: Int

  /**
   *
   * @return Current HP of the `Entity`
   */
  def currentHp: Int

  /**
   *
   * @return Current star count of the `Entity`
   */
  def stars: Int

  /** Adds HP up to the maximum allowed HP
   *
   * @param dHp Max amount of HP to add. Must be non-negative.
   * @return Amount of HP actually added
   */
  def addHp(dHp: Int): Int

  /** Adds stars to the current star count
   *
   * @param amount Amount of stars to add. Must be non-negative.
   * @return Amount of stars actually added
   */
  def addStars(amount: Int): Int

  /** Takes away HP until 0 is reached
   *
   * @param dHp Max amount of HP to take away. Must be non-negative.
   * @return Amount of HP actually taken away
   */

  def deductHp(dHp: Int): Int

  /** Takes away stars until 0 is reached
   *
   * @param amount Max amount of stars to take away. Must be non-negative.
   * @return Amount of stars actually taken away
   */
  def deductStars(amount: Int): Int

  /** Called when the unit starts its turn
   *
   */
  def startTurn(chapter: Int): Unit

  /** Rolls a dice and returns a value between 1 to 6.
   */
  def rollDice(): Int

  /** Used when the Entity attacks another Entity
   *
   * @return The roll produced by this `Entity`'s attack
   */
  def attackRoll: Int

  /** Used when the `Entity` chooses to defend from another `Entity`'s attack
   * Deducts the HP caused by the attack after defense is applied
   *
   * @param atkRoll The attack roll the `Entity` has chosen to defend against
   */
  def defendRoll(atkRoll: Int): Unit

  /** Used when the `Entity` chooses to evade another `Entity`'s attack
   *
   * @param atkRoll The attack roll the `Entity` has chosen to evade
   */
  def evadeRoll(atkRoll: Int): Unit

  /**
   *
   * @return The amount of victories the `Entity` gives when defeated
   */
  def givesVictories: Int

  /** Processes the logic for this `Entity` being defeated by a Player
   *
   * @param player The player that defeated this entity
   */
  def defeatedByPlayer(player: Player): Unit

  /** Processes the logic for this `Entity` being defeated by a Wild Unit
   *
   * @param wildUnit The Wild Unit that defeated this entity
   */
  def defeatedByWildUnit(wildUnit: WildUnit): Unit

  /** Processes the logic for `this` defeating `enemy`.
   *
   * @param enemy The `Entity` this `Entity` has defeated.
   */
  def defeatEnemy(enemy: Entity): Unit
}
