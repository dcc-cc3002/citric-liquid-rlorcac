package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter

import cl.uchile.dcc.citric.model.panels.Panel
import munit.FunSuite

class DropPanelTest extends FunSuite {
  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new DropPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion
    )
  }

  test("Landing on a Drop Panel should take away stars") {
    character.addStars(30)
    assertEquals(character.getStars, 30)
    panel.addCharacter(character)
    assertNotEquals(character.getStars, 30)
  }

}
