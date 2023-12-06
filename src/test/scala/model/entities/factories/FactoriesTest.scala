package cl.uchile.dcc.citric
package model.entities.factories

import model.entities.WildUnit

class FactoriesTest extends munit.FunSuite {
  private var chicken: WildUnit = _
  private var roboBall: WildUnit = _
  private var seagull: WildUnit = _
  private val chickenFactory = new ChickenFactory()
  private val seagullFactory = new SeagullFactory()
  private val roboBallFactory = new RoboBallFactory()
  override def beforeEach(context: BeforeEach): Unit = {
    chicken = chickenFactory.create()
    roboBall = roboBallFactory.create()
    seagull = seagullFactory.create()
  }
  test("Chickens should start with 3 stars, full HP, 3 HP, -1 ATK, -1 DEF, and 1 EVA"){
    chicken.startTurn(1)
    assertEquals(chicken.stars, 3)
    assertEquals(chicken.currentHp, chicken.maxHp)
    assertEquals(chicken.maxHp, 3)
    assertEquals(chicken.attack, -1)
    assertEquals(chicken.defense, -1)
    assertEquals(chicken.evasion, 1)
  }

  test("RoboBalls should start with 2 stars, full HP, 3 HP, -1 ATK, 1 DEF, and -1 EVA") {
    roboBall.startTurn(1)
    assertEquals(roboBall.stars, 2)
    assertEquals(roboBall.currentHp, roboBall.maxHp)
    assertEquals(roboBall.maxHp, 3)
    assertEquals(roboBall.attack, -1)
    assertEquals(roboBall.defense, 1)
    assertEquals(roboBall.evasion, -1)
  }

  test("Seagulls should start with 2 stars, full HP, 3 HP, 1 ATK, -1 DEF, and -1 EVA") {
    seagull.startTurn(1)
    assertEquals(seagull.stars, 2)
    assertEquals(seagull.currentHp, seagull.maxHp)
    assertEquals(seagull.maxHp, 3)
    assertEquals(seagull.attack, 1)
    assertEquals(seagull.defense, -1)
    assertEquals(seagull.evasion, -1)
  }

}
