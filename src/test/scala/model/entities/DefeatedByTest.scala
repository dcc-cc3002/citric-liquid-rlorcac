package cl.uchile.dcc.citric
package model.entities

import cl.uchile.dcc.citric.model.randomizer.Randomize
import munit.FunSuite

import scala.util.Random

class DefeatedByTest extends FunSuite {
  private var player1: Player = _
  private var player2: Player = _
  private var wildUnit1: WildUnit = _
  private var wildUnit2: WildUnit = _
  private var randomNumberGenerator: Random = _
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(13)
    player1 = new PlayerCharacter(name1,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    player2 = new PlayerCharacter(name2,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    wildUnit1 = new Randomize().randomUnit()
    wildUnit2 = new Randomize().randomUnit()
  }

  test("Player defeated by Player"){
    player1.addStars(2)
    player2.addStars(2)
    player2.defeatedBy(player1)
    assertEquals(player1.stars, 3)
    assertEquals(player1.victories, 2)
    assertEquals(player2.stars, 1)
    assertEquals(player2.victories, 0)
  }

  test("Player defeated by Wild Unit"){
    player1.addStars(2)
    val originalStars = wildUnit1.stars
    player1.defeatedBy(wildUnit1)
    assertEquals(player1.stars, 1)
    assertEquals(player1.victories, 0)
    assertEquals(wildUnit1.stars, originalStars + 1)
  }

  test("Wild Unit defeated by Player"){
    player1.addStars(2)
    val originalStars = wildUnit1.stars
    println(originalStars)
    wildUnit1.defeatedBy(player1)
    assertEquals(player1.stars, 2 + originalStars)
    assertEquals(player1.victories, 1)
    assertEquals(wildUnit1.stars, 0)
  }

  test("Wild Unit defeated by Wild Unit (should do nothing)"){
    wildUnit1.addStars(2)
    wildUnit2.addStars(5)
    val originalStars1 = wildUnit1.stars
    val originalStars2 = wildUnit2.stars
    wildUnit2.defeatedBy(wildUnit1)
    assertEquals(wildUnit1.stars, originalStars1)
    assertEquals(wildUnit2.stars, originalStars2)
  }
}
