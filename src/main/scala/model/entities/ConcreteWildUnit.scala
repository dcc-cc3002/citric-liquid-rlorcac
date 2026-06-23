package cl.uchile.dcc.citric
package model.entities

/** An abstract representation of a Wild Unit
 *
 * @param maxHp The maximum health points a wild unit can have. It represents its endurance.
 * @param attack The wild unit's capability to deal damage to opponents.
 * @param defense The wild unit's capability to resist or mitigate damage from opponents.
 * @param evasion The wild unit's skill to completely avoid certain attacks.
 * @param stars The amount of stars the wild unit starts with.
 */
class ConcreteWildUnit(maxHp: Int,
                                attack: Int,
                                defense: Int,
                                evasion: Int,
                                stars: Int) extends AbstractEntity(maxHp, attack, defense, evasion, stars)
                       with WildUnit {
  /** Called when the unit starts its turn
   *
   *  For a WildUnit, this method does nothing.
   */
  def startTurn(chapter: Int): Unit = {
  }

  override def givesVictories: Int = 1

  override def defeatedByWildUnit(wildUnit: WildUnit): Unit = {
    // do nothing
  }

  override def defeatedByPlayer(player: Player): Unit = {
    player.addStars(stars)
    player.addVictories(givesVictories)
    deductStars(stars)
  }

  override def defeatEnemy(enemy: Entity): Unit = enemy.defeatedByWildUnit(this)
}
