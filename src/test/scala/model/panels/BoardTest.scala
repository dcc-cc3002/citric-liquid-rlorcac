package cl.uchile.dcc.citric
package model.panels

import model.entities.{Player, PlayerCharacter}

import munit.FunSuite

import scala.util.Random

class BoardTest extends FunSuite {
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _
  private var player1: Player = _
  private var player2: Player = _
  private var board: Board = _

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
    board = new Board(List(player1, player2), 20)
  }

  test("Board size"){
    for(i <- 1 to 20){
      board = new Board(List(player1, player2), i)
      assertEquals(board.boardSize, 2 + i)
    }
  }

  test("Players' Home Panels"){
    for(player <- List(player1, player2)){
      assert(board.homePanels.map(x => x.owner).contains(player))
    }
  }

  test("Home Panels are contained within the full list of panels"){
    for(homePanel <- board.homePanels){
      assert(board.panels.contains(homePanel))
    }
  }
}
