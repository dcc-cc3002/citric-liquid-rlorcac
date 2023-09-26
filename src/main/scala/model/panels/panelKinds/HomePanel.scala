package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.AbstractPanel

/** Represents a panel that's home to a `PlayerCharacter`, where they can Norma Clear
 *
 * @param owner The PlayerCharacter that has this panel set as their HomePanel
 */
class HomePanel(val owner: PlayerCharacter) extends AbstractPanel{
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = {
    /** Check if player can perform a normaClear
     *
     */
    player.addHp(1)
    player.normaCheck()
  }
}
