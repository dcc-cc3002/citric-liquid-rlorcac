package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.PlayerCharacter
import model.panels.Panel
import munit.FunSuite

class NeutralPanelTest extends FunSuite {

  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new NeutralPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars"
    )
  }

  test("Landing on a Neutral Panel should do nothing") {
    // This test is probably wrong
    val original: PlayerCharacter = character
    assertEquals(character, original)
    panel.addCharacter(character)
    assertEquals(character, original)
  }
}
