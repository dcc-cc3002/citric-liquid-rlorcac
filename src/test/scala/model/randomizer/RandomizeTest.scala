package cl.uchile.dcc.citric
package model.randomizer

import scala.util.Random

class RandomizeTest extends munit.FunSuite {
  private var rand: RandomizedFactory = _
  private var rng: Random = _

  override def beforeEach(context: BeforeEach): Unit = {
    rand = new RandomizedFactory()
    rng = new Random(11)
  }

  test("Generated WildUnit's class should be in the allowed list of classes"){
    for(_ <- 1 to 10){
      assert(rand.getWildUnitFactoryList.map(x => x.create().getClass).contains(rand.randomUnit().getClass))
    }
  }

  test("Generated Panel's class should be in the allowed list of classes"){
    for (_ <- 1 to 10) {
      assert(rand.getPanelList.map(x => x.getClass).contains(rand.randomPanel().getClass))
    }
  }

  test("Two consecutive calls should produce different instances") {
    assertNotEquals(rand.getPanelList, rand.getPanelList)
    assertNotEquals(rand.getWildUnitFactoryList, rand.getWildUnitFactoryList)
  }

}
