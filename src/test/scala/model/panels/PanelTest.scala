package cl.uchile.dcc.citric
package model.panels

import model.entities.PlayerCharacter
import model.randomizer.{RandomPanelFactory, RandomizedFactory}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelTest extends FunSuite {
  private var character: PlayerCharacter = _
  private var panel: Panel = _
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val panelFactory = new RandomPanelFactory()

  override def beforeEach(context: BeforeEach): Unit = {
    panel = panelFactory.create()
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars"
    )
  }

  test("Players can enter and leave panels") {
    panel.addCharacter(character)
    assertEquals(panel.characters.contains(character), true)
    panel.removeCharacter(character)
    assertEquals(panel.characters.contains(character), false)
  }

  test("A panel's next panels can be added to"){
    val nextPanel: Panel = panelFactory.create()
    panel.addNextPanel(nextPanel)
    assert(panel.nextPanels.contains(nextPanel))
  }

  test("A panel's next panels can be removed from") {
    val panels: ArrayBuffer[Panel] = ArrayBuffer()
    for(_ <- 1 to 10){
      val nextPanel: Panel = panelFactory.create()
      panel.addNextPanel(nextPanel)
      panels.append(nextPanel)
    }
    for(_ <- 1 to 10){
      val choice = new Random().nextInt(panels.size)
      val chosen: Panel = panels(choice)
      panels.remove(choice)
      assertEquals(panel.nextPanels.contains(chosen), true)
      panel.removeNextPanel(chosen)
      assertEquals(panel.nextPanels.contains(chosen), false)
    }
    assertEquals(panel.nextPanels.isEmpty, true)
  }
}
