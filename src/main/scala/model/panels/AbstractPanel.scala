package cl.uchile.dcc.citric
package model.panels

import model.entities.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Implements general
 *
 */
abstract class AbstractPanel extends Panel{
  private val _characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]
  private var _nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]

  override def characters: ArrayBuffer[PlayerCharacter] = _characters.clone()

  override def nextPanels: ArrayBuffer[Panel] = _nextPanels.clone()

  def nextPanels_=(newNext: ArrayBuffer[Panel]):Unit = {_nextPanels = newNext}

  def addCharacter(player: PlayerCharacter): Unit = {
    _characters.append(player)
    activate(player)
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    if(!this.characters.contains(player)) throw new Exception("Player not found in requested panel")
    while(this.characters.contains(player)){
      _characters.remove(characters.indexOf(player))
    }
  }
}
