package cl.uchile.dcc.citric
package model.norma.kinds

import controller.GameController
import model.entities.{Player, PlayerCharacter}

import munit.FunSuite

import scala.util.Random

class NormaKindsTest extends FunSuite {
  private var player: Player = _
  private var randomNumberGenerator: Random = _
  private val name = "testPlayer1"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(1)
    player = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    controller = new GameController(List(player), 1)
  }

  test("Norma1 creates a Norma2"){
    val norma = new Norma1("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 2)
    assertEquals(next.goal, "Victories, 3")
  }

  test("Norma2 creates a Norma3") {
    val norma = new Norma2("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 3)
  }

  test("Norma3 creates a Norma4") {
    val norma = new Norma3("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 4)
  }

  test("Norma4 creates a Norma5") {
    val norma = new Norma4("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 5)
  }

  test("Norma5 creates a Norma6 and also causes the game to end") {
    assertEquals(controller.state.getStateName, "PreGame")
    val norma = new Norma5("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 6)
    assertEquals(controller.state.getStateName, "EndGame")
  }

  test("Norma6 creates itself and also causes the game to end") {
    assertEquals(controller.state.getStateName, "PreGame")
    val norma = new Norma6("Stars", player)
    val next = norma.next("Victories")
    assertEquals(next.level, 6)
    assertEquals(next.goal, norma.goal)
    assertEquals(controller.state.getStateName, "EndGame")
  }
}
