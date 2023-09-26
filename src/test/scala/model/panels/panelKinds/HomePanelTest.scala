package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.Panel

import munit.FunSuite

class HomePanelTest extends FunSuite {
  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion
    )
    panel = new HomePanel(character)
  }

  test("Landing on a Home Panel should currently do nothing") {
    //TODO: Update to future expected implementation
    val original: PlayerCharacter = character
    assertEquals(character, original)
    panel.addCharacter(character)
    assertEquals(character, original)
  }
}
