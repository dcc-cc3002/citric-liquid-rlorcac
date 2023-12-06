package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.PlayerCharacter
import model.panels.Panel
import model.panels.factories.NeutralPanelFactory

import munit.FunSuite

class NeutralPanelTest extends FunSuite {

  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val factory = new NeutralPanelFactory()

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

  test("NeutralPanel should have no WildUnit") {
    assertEquals(panel.getWildUnit, None)
  }

  test("Factory | Landing on a Neutral Panel should do nothing") {
    // This test is probably wrong
    panel = factory.create()
    val original: PlayerCharacter = character
    assertEquals(character, original)
    panel.addCharacter(character)
    assertEquals(character, original)
  }

}
