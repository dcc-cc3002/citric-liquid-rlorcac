package cl.uchile.dcc.citric
package model.entities

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
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
  private var character1: Player = _  // <- x = _ is the same as x = null
  private var character2: Player = _

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character1 = new PlayerCharacter(
      name1,
      maxHp,
      attack,
      defense,
      evasion,
      "Stars",
      randomNumberGenerator
    )
    character2 = new PlayerCharacter(
        name1,
        maxHp,
        attack,
        defense,
        evasion,
        "Victories",
        randomNumberGenerator
      )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character1.name, name1)
    assertEquals(character1.maxHp, maxHp)
    assertEquals(character1.attack, attack)
    assertEquals(character1.defense, defense)
    assertEquals(character1.evasion, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character1.rollDice >= 1 && character1.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name2, maxHp, attack, defense, evasion, "Stars", new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character1.rollDice(), other.rollDice())
    }
  }

  test("A character should start with full HP") {
    assertEquals(character1.currentHp, character1.maxHp)
  }

  test("A character should not be able to have higher HP than maxHp"){
    character1.addHp(1)
    assertEquals(character1.currentHp, character1.maxHp)
  }

  test("Adding negative HP to a character should do nothing"){
    character1.addHp(-1)
    assertEquals(character1.currentHp, character1.maxHp)
  }

  test("Deducting maxHp from a character should leave them at 0 HP"){
    character1.deductHp(character1.maxHp)
    assertEquals(character1.currentHp, 0)
  }

  test("Deducting HP from a character with no HP should leave them at 0 HP"){
    character1.deductHp(character1.maxHp) // character should have 0 HP per previous test
    character1.deductHp(1)
    assertEquals(character1.currentHp, 0)
  }

  test("Deducting negative HP from a character should do nothing"){
    character1.deductHp(-1)
    assertEquals(character1.currentHp, character1.maxHp)
  }

  test("Characters should start with 0 stars and 0 victories"){
    assertEquals(character1.stars, 0)
    assertEquals(character1.victories, 0)
  }

  test("Adding positive stars to a character should add the exact amount"){
    character1.addStars(2)
    assertEquals(character1.stars, 2)
  }

  test("Adding negative stars to a character should do nothing"){
    character1.addStars(-1)
    assertEquals(character1.stars, 0)
  }

  test("Deducting stars from a character with 0 stars should leave them at 0 stars"){
    character1.deductStars(5)
    assertEquals(character1.stars, 0)
  }

  test("Deducting negative stars from a character should do nothing"){
    character1.deductStars(-1)
    assertEquals(character1.stars, 0)
  }

  test("Victories management") {
    assertEquals(character1.victories, 0)
    character1.addVictories(1)
    assertEquals(character1.victories, 1)
    character1.addVictories(-1)
    assertEquals(character1.victories, 1)
  }

  test("A character should start at Norma 1, then be able to proceed to Norma 2 once their goal is achieved"){
    assertEquals(character1.norma, 1)
    assertEquals(character1.stars, 0)
    character1.addStars(10)
    assertEquals(character1.stars, 10)
    character1.normaCheck("Victories")
    assertEquals(character1.norma, 2)
  }

  test("A character should be able to Norma Clear with both stars and victories"){
    assertEquals(character1.getGoal, "Stars, 10")
    character1.addStars(10)
    character1.normaCheck("Victories")
    assertEquals(character1.norma, 2)
    assertEquals(character1.getGoal, "Victories, 3")
    character1.addVictories(3)
    character1.normaCheck("Stars")
    assertEquals(character1.norma, 3)
  }

  test("A character should be able to start their turn, and starting the turn should add stars"){
    val originalStars = character1.stars
    character1.startTurn(1)
    assertNotEquals(originalStars, character1.stars)
  }

  test("A character should be able to roll for attack"){
    for(_ <- 1 to 10){
      val atkRoll = character1.attackRoll
      assert(atkRoll >= character1.attack + 1)
      assert(atkRoll <= character1.attack + 6)
    }
  }
  test("A character should be able to defend from an attack") {
    for (_ <- 1 to 10) {
      character2.addHp(character2.maxHp) // Heal to max
      val originalHp = character2.currentHp
      character2.defendRoll(character1)
      assert(character2.currentHp < originalHp)
      assert(character2.currentHp >= 0)
    }
  }
  test("A character should be able to evade an attack") {
    for (_ <- 1 to 10) {
      character2.addHp(character2.maxHp) // Heal to max
      val originalHp = character2.currentHp
      character2.evadeRoll(character1)
      assert(character2.currentHp <= originalHp)
      assert(character2.currentHp >= 0)
    }
  }
}
