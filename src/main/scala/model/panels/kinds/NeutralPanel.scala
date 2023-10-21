package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.PlayerCharacter
import model.panels.AbstractPanel

/** Represents a panel that does nothing when a player lands on it.
 *
 */
class NeutralPanel extends AbstractPanel {
  /** To be called when a `PlayerCharacter` lands on a `Panel`
   *
   * In the case of a `NeutralPanel`, it does nothing
   *
   * @param player The `PlayerCharacter` that landed on the `Panel`
   */
  def activate(player: PlayerCharacter): Unit = {}
}
