package cl.uchile.dcc.citric
package model.panels.panelKinds

import model.entities.PlayerCharacter
import model.panels.Panel
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  private var character: PlayerCharacter = _
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
      evasion
    )
  }
  test("Landing on a Bonus Panel should add stars"){
    assertEquals(character.getStars, 0)
    panel.addCharacter(character)
    assertNotEquals(character.getStars, 0)
  }
}
