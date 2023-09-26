package cl.uchile.dcc.citric
package model.panels

import model.entities.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Implements general
 *
 */
abstract class AbstractPanel extends Panel{
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]
  def addCharacter(player: PlayerCharacter): Unit = {
    characters.append(player)
    activate(player)
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    if(!this.characters.contains(player)) throw new Exception("Player not found in requested panel")
    while(this.characters.contains(player)){
      characters.remove(characters.indexOf(player))
    }
  }
}
