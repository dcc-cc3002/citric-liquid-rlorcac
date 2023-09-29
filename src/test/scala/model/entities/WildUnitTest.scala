package cl.uchile.dcc.citric
package model.entities

import model.entities.defaultEntities.{Chicken, RoboBall, Seagull}

class WildUnitTest extends munit.FunSuite {
  private var chicken: WildUnit = _
  private var roboBall: WildUnit = _
  private var seagull: WildUnit = _
  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
    roboBall = new RoboBall()
    seagull = new Seagull()
  }
  test("Chickens should start with 0 stars, full HP, 3 HP, -1 ATK, -1 DEF, and 1 EVA"){
    chicken.startTurn()
    assertEquals(chicken.getStars, 0)
    assertEquals(chicken.currentHp, chicken.maxHp)
    assertEquals(chicken.maxHp, 3)
    assertEquals(chicken.attack, -1)
    assertEquals(chicken.defense, -1)
    assertEquals(chicken.evasion, 1)
  }

  test("RoboBalls should start with 0 stars, full HP, 3 HP, -1 ATK, 1 DEF, and -1 EVA") {
    roboBall.startTurn()
    assertEquals(roboBall.getStars, 0)
    assertEquals(roboBall.currentHp, roboBall.maxHp)
    assertEquals(roboBall.maxHp, 3)
    assertEquals(roboBall.attack, -1)
    assertEquals(roboBall.defense, 1)
    assertEquals(roboBall.evasion, -1)
  }

  test("Seagulls should start with 0 stars, full HP, 3 HP, 1 ATK, -1 DEF, and -1 EVA") {
    seagull.startTurn()
    assertEquals(seagull.getStars, 0)
    assertEquals(seagull.currentHp, seagull.maxHp)
    assertEquals(seagull.maxHp, 3)
    assertEquals(seagull.attack, 1)
    assertEquals(seagull.defense, -1)
    assertEquals(seagull.evasion, -1)
  }

}
