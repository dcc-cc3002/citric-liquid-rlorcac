package cl.uchile.dcc.citric
package model.panels

import model.entities.PlayerCharacter

import model.randomizer.Randomize
import munit.FunSuite

class PanelTest extends FunSuite {
  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new Randomize().randomPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion
    )
  }

  test("Players can enter and leave panels") {
    panel.addCharacter(character)
    assertEquals(panel.characters.contains(character), true)
    panel.removeCharacter(character)
    assertEquals(panel.characters.contains(character), false)
  }
}
