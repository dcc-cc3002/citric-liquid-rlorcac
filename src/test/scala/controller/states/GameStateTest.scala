package cl.uchile.dcc.citric
package controller.states

import controller.GameController
import controller.states.kinds._
import exceptions.InvalidStateTransitionException
import model.entities.{Player, PlayerCharacter, WildUnit}
import model.randomizer.RandomWildUnitFactory

import munit.FunSuite
import org.junit.Assert

import scala.util.Random

class GameStateTest extends FunSuite {
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val name3 = "testPlayer3"
  private val name4 = "testPlayer4"
  private val maxHp = 1
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
    controller = new GameController(List(player1, player2, player3, player4), 1)
    wildUnit = new RandomWildUnitFactory().create()
  }

  test("NullState test"){
    state = new NullState(controller)
    controller.setState(state)
    assertEquals(state.getStateName, "NullState")
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.failRecovery())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.passRecovery())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.rollDie())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.startTurn(player1))
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.endTurn())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.startRecovery())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.startGame())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.startPlayerCombat(player2))
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.startWildUnitCombat(wildUnit))
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.newGame())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.endCombat())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.landOnPanel())
    Assert.assertThrows(classOf[InvalidStateTransitionException], () => state.combatRound())
    assertEquals(state.getStateName, "NullState")
  }

  test("Recovery State test"){
    player1.deductHp(player1.maxHp)
    state = new Recovery(controller, player1)
    assert(List(0, player1.maxHp).contains(player1.currentHp))
    state = new Recovery(controller, player1)
    state.passRecovery()
    assertEquals(controller.state.getStateName, "PlayerTurn")
    state = new Recovery(controller, player1)
    state.failRecovery()
    assertEquals(controller.state.getStateName, "MainLoop")
  }

  test("EndGame State test"){
    state = new EndGame(controller)
    state.newGame()
    assertEquals(controller.state.getStateName, "PreGame")
    controller.startGame()
  }

  test("PlayerCombat State test"){
    state = new PlayerCombat(controller, player1, player2)
    for(_ <- 1 to 10){
      state.combatRound()
    }
    assert(List(player1, player2).map(x => x.currentHp).contains(0))
    player2.addHp(player2.maxHp)
    player1.deductHp(player1.maxHp)
    state.combatRound()
    assertEquals(player2.currentHp, player2.maxHp)
    assertEquals(player1.currentHp, 0)
    player1.addHp(player1.maxHp)
    player2.deductHp(player2.maxHp)
    state.combatRound()
    assertEquals(player2.currentHp, 0)
    assertEquals(player1.currentHp, player1.maxHp)
  }

  test("WildUnitCombat State test"){
    state = new WildUnitCombat(controller, player1, wildUnit)
    for (_ <- 1 to 10) {
      state.combatRound()
    }
    assert(List(player1, wildUnit).map(x => x.currentHp).contains(0))
    wildUnit.addHp(wildUnit.maxHp)
    player1.deductHp(player1.maxHp)
    state.combatRound()
    assertEquals(wildUnit.currentHp, wildUnit.maxHp)
    assertEquals(player1.currentHp, 0)
    player1.addHp(player1.maxHp)
    wildUnit.deductHp(wildUnit.maxHp)
    state.combatRound()
    assertEquals(wildUnit.currentHp, 0)
    assertEquals(player1.currentHp, player1.maxHp)
  }

  test("PlayerTurn State test"){
    state = new PlayerTurn(controller, player1)
    state.startRecovery()
    assertEquals(controller.state.getStateName, "Recovery")

  }
}
