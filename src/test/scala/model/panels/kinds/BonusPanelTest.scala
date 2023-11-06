package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.{Player, PlayerCharacter}
import model.panels.Panel

class BonusPanelTest extends munit.FunSuite {
  private var character: Player = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new BonusPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars"
    )
  }
  test("Landing on a Bonus Panel should add stars"){
    assertEquals(character.stars, 0)
    panel.addCharacter(character)
    assertNotEquals(character.stars, 0)
  }
}
