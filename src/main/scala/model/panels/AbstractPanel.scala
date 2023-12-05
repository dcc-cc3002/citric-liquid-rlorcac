package cl.uchile.dcc.citric
package model.panels

import model.entities.{Player, WildUnit}

import scala.collection.mutable.ArrayBuffer

/** Implements general features of a panel
 *
 */
abstract class AbstractPanel extends Panel{
  private val _characters: ArrayBuffer[Player] = new ArrayBuffer[Player]
  private val _nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]

  override def characters: ArrayBuffer[Player] = _characters.clone() // TODO: this returns a clone of the list but elements are still the same (mutable)

  override def nextPanels: ArrayBuffer[Panel] = _nextPanels.clone() // TODO: this returns a clone of the list but elements are still the same (mutable)

  def addCharacter(player: Player): Unit = {
    _characters.append(player)
    activate(player)
  }

  def removeCharacter(player: Player): Unit = {
    if(!this._characters.contains(player)) return
    while(this._characters.contains(player)){
      _characters.remove(_characters.indexOf(player))
    }
  }

  override def addNextPanel(panel: Panel): Unit = {
    this._nextPanels.append(panel)
  }

  override def removeNextPanel(panel: Panel): Unit = {
    if (!this._nextPanels.contains(panel)) return
    while (this._nextPanels.contains(panel)) {
      _nextPanels.remove(_nextPanels.indexOf(panel))
    }
  }

  override def getWildUnit: Option[WildUnit] = None
}
