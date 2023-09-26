package cl.uchile.dcc.citric
package model.randomizer

import scala.util.Random

class RandomizeTest extends munit.FunSuite {
  private var rand: Randomize = _
  private var rng: Random = _

  override def beforeEach(context: BeforeEach): Unit = {
    rand = new Randomize()
    rng = new Random(11)
  }

  test("Generated WildUnits should be in the allowed list"){
    for(_ <- 1 to 10){
      assert(rand.getWildUnitList.contains(rand.randomUnit()))
    }
  }

  test("Generated Panels should be in the allowed list"){
    for (_ <- 1 to 10) {
      assert(rand.getPanelList.contains(rand.randomPanel()))
    }
  }

  test("Two consecutive calls should produce different instances") {
    assertNotEquals(rand.getPanelList, rand.getPanelList)
    assertNotEquals(rand.getWildUnitList, rand.getWildUnitList)
  }

}
