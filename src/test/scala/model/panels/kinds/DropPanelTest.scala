package cl.uchile.dcc.citric
package model.panels.kinds

import model.entities.{Player, PlayerCharacter}
import model.panels.Panel
import model.panels.factories.DropPanelFactory

import munit.FunSuite

class DropPanelTest extends FunSuite {
  private var character: Player = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val factory = new DropPanelFactory()

  override def beforeEach(context: BeforeEach): Unit = {
    panel = new DropPanel()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars"
    )
  }

  test("Landing on a Drop Panel should take away stars") {
    character.addStars(30)
    assertEquals(character.stars, 30)
    panel.addCharacter(character)
    assertNotEquals(character.stars, 30)
  }

  test("DropPanel should have no WildUnit") {
    assertEquals(panel.getWildUnit, None)
  }

  test("Factory | Landing on a Drop Panel should take away stars") {
    panel = factory.create()
    character.addStars(30)
    assertEquals(character.stars, 30)
    panel.addCharacter(character)
    assertNotEquals(character.stars, 30)
  }

}
