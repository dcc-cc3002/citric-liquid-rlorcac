package cl.uchile.dcc.citric
package model.entities

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }

  test("A character should start with full HP") {
    assertEquals(character.currentHp, character.maxHp)
  }

  test("A character should not be able to have higher HP than maxHp"){
    character.addHp(1)
    assertEquals(character.currentHp, character.maxHp)
  }

  test("Adding negative HP to a character should do nothing"){
    character.addHp(-1)
    assertEquals(character.currentHp, character.maxHp)
  }

  test("Deducting maxHp from a character should leave them at 0 HP"){
    character.deductHp(character.maxHp)
    assertEquals(character.currentHp, 0)
  }

  test("Deducting HP from a character with no HP should leave them at 0 HP"){
    character.deductHp(character.maxHp) // character should have 0 HP per previous test
    character.deductHp(1)
    assertEquals(character.currentHp, 0)
  }

  test("Deducting negative HP from a character should do nothing"){
    character.deductHp(-1)
    assertEquals(character.currentHp, character.maxHp)
  }

  test("Characters should start with 0 stars and 0 victories"){
    assertEquals(character.stars, 0)
    assertEquals(character.getVictories, 0)
  }

  test("Adding positive stars to a character should add the exact amount"){
    character.addStars(2)
    assertEquals(character.stars, 2)
  }

  test("Adding negative stars to a character should do nothing"){
    character.addStars(-1)
    assertEquals(character.stars, 0)
  }

  test("Deducting stars from a character with 0 stars should leave them at 0 stars"){
    character.deductStars(5)
    assertEquals(character.stars, 0)
  }

  test("Deducting negative stars from a character should do nothing"){
    character.deductStars(-1)
    assertEquals(character.stars, 0)
  }

  test("Victories management") {
    assertEquals(character.getVictories, 0)
    character.addVictories(1)
    assertEquals(character.getVictories, 1)
    character.addVictories(-1)
    assertEquals(character.getVictories, 1)
  }

  test("A character should start at Norma 1, then be able to proceed to Norma 2 once their goal is achieved"){
    assertEquals(character.getNorma, 1)
    character.setGoal(("Stars", 1))
    assertEquals(character.stars, 0)
    character.addStars(1)
    assertEquals(character.stars, 1)
    character.normaCheck()
    assertEquals(character.getNorma, 2)
  }

  test("A character should be able to Norma Clear with both stars and victories"){
    character.setGoal(("Stars", 1))
    assertEquals(character.getGoal, "1 Stars")
    character.addStars(1)
    character.normaCheck()
    assertEquals(character.getNorma, 2)
    character.setGoal(("Victories",1))
    character.addVictories(1)
    character.normaCheck()
    assertEquals(character.getNorma, 3)

  }

  test("A character should be able to start their turn"){
    character.startTurn()
  }
}
