package cl.uchile.dcc.citric
package model.randomizer

import munit.FunSuite

import scala.util.Random

class RandomWildUnitFactoryTest extends FunSuite {
  private var rand: RandomWildUnitFactory = _
  private var rng: Random = _

  override def beforeEach(context: BeforeEach): Unit = {
    rng = new Random(11)
    rand = new RandomWildUnitFactory(rng)
  }

  test("Generated WildUnit's class should be in the allowed list of classes") {
    for (_ <- 1 to 10) {
      assert(rand.factoryList.map(x => x.getClass).contains(rand.create().getClass))
    }
  }
  test("Two consecutive calls should produce different instances of WildUnit") {
    for (_ <- 1 to 10) {
      assertNotEquals(rand.create(), rand.create())
    }
  }

}
