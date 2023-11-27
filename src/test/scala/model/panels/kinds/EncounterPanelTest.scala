package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.{PlayerCharacter, WildUnit}

import munit.FunSuite

class EncounterPanelTest extends FunSuite {

  private var character: PlayerCharacter = _
  private var panel: EncounterPanel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

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

  test("Landing on a Bonus Panel should add stars") {
    assertEquals(panel.getCurrentUnit, None)
    panel.addCharacter(character)
    assertEquals(panel.getCurrentUnit.isEmpty, false)
  }
}
