package cl.uchile.dcc.citric
package controller

import controller.states.GameState
import model.entities.{Player, PlayerCharacter, WildUnit}
import model.randomizer.RandomWildUnitFactory

import munit.FunSuite

import scala.util.Random

class GameControllerTest extends FunSuite {

  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val name3 = "testPlayer3"
  private val name4 = "testPlayer4"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _
  private var player1: Player = _
  private var player2: Player = _
  private var player3: Player = _
  private var player4: Player = _
  private var controller: GameController = _
  private var state: GameState = _
  private var wildUnit: WildUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    player1 = new PlayerCharacter(
      name1,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    player2 = new PlayerCharacter(
      name2,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    player3 = new PlayerCharacter(
      name3,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    player4 = new PlayerCharacter(
      name4,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    controller = new GameController(List(player1, player2, player3, player4), 20)
    wildUnit = new RandomWildUnitFactory().create()
  }
  test("Start Game"){
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
    assertEquals(controller.state.getStateName, "MainLoop")
  }
  test("One player's turn"){
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
    assertEquals(controller.state.getStateName, "MainLoop")
    controller.playerTurn(player1)
    assertEquals(controller.state.getStateName, "MainLoop")
  }

  test("One player, multiple turns") {
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
    for(i <- 1 to 10){
      assertEquals(controller.state.getStateName, "MainLoop")
      controller.playerTurn(player1)
    }
    assertEquals(controller.state.getStateName, "MainLoop")
  }

  test("Multiple players, one turn") {
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
    controller.turn()
    assertEquals(controller.state.getStateName, "MainLoop")
  }

  test("Multiple players, multiple turns"){
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
    for(i <- 1 to 10){
      controller.turn()
    }
    assertEquals(controller.state.getStateName, "MainLoop")
  }
}
