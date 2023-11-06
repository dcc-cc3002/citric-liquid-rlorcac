package cl.uchile.dcc.citric
package model.norma.kinds

import munit.FunSuite

class NormaKindsTest extends FunSuite {
  test("Norma1 creates a Norma2"){
    val norma = new Norma1("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 2)
    assertEquals(next.goal, "Victories, 3")
  }

  test("Norma2 creates a Norma3") {
    val norma = new Norma2("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 3)
  }

  test("Norma3 creates a Norma4") {
    val norma = new Norma3("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 4)
  }

  test("Norma4 creates a Norma5") {
    val norma = new Norma4("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 5)
  }

  test("Norma5 creates a Norma6") {
    val norma = new Norma5("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 6)
  }

  test("Norma6 creates itself") {
    val norma = new Norma6("Stars")
    val next = norma.next("Victories")
    assertEquals(next.level, 6)
    assertEquals(next.goal, norma.goal)
  }
}
