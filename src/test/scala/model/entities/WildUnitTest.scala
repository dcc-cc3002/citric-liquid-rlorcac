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
  test("Chicken test"){
    chicken.startTurn()
    assertEquals(chicken.getStars, 0)
    assertEquals(chicken.getCurrentHp, chicken.maxHp)
    assertEquals(chicken.maxHp, 3)
    assertEquals(chicken.attack, -1)
    assertEquals(chicken.defense, -1)
    assertEquals(chicken.evasion, 1)
  }

  test("RoboBall test") {
    roboBall.startTurn()
    assertEquals(roboBall.getStars, 0)
    assertEquals(roboBall.getCurrentHp, roboBall.maxHp)
    assertEquals(roboBall.maxHp, 3)
    assertEquals(roboBall.attack, -1)
    assertEquals(roboBall.defense, 1)
    assertEquals(roboBall.evasion, -1)
  }

  test("Seagull test") {
    seagull.startTurn()
    assertEquals(seagull.getStars, 0)
    assertEquals(seagull.getCurrentHp, seagull.maxHp)
    assertEquals(seagull.maxHp, 3)
    assertEquals(seagull.attack, 1)
    assertEquals(seagull.defense, -1)
    assertEquals(seagull.evasion, -1)
  }

}
