package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.PlayerCharacter
import model.panels.factories.EncounterPanelFactory

import munit.FunSuite

class EncounterPanelTest extends FunSuite {

  private var character: PlayerCharacter = _
  private var panel: EncounterPanel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val factory = new EncounterPanelFactory()

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new EncounterPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars"
    )
  }

  test("Landing on an Encounter Panel should create a WildUnit in the panel") {
    assertEquals(panel.getWildUnit, None)
    panel.addCharacter(character)
    assertEquals(panel.getWildUnit.isEmpty, false)
  }

  test("Factory | Landing on an Encounter Panel should create a WildUnit in the panel") {
    panel = factory.create()
    assertEquals(panel.getWildUnit, None)
    panel.addCharacter(character)
    assertEquals(panel.getWildUnit.isEmpty, false)
  }
}
