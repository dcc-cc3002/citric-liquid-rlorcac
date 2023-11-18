package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.Player
import model.panels.AbstractPanel

/** Represents a panel that's home to a `PlayerCharacter`, where they can Norma Clear
 *
 * @param owner The PlayerCharacter that has this panel set as their HomePanel
 */
class HomePanel(val owner: Player) extends AbstractPanel{
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: Player): Unit = {
    player.addHp(1)
    player.normaCheck(player.setGoal("Stars"))
  }
}
