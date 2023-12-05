package cl.uchile.dcc.citric
package model.randomizer

import munit.FunSuite

import scala.util.Random

class RandomPanelFactoryTest extends FunSuite {
  private var rand: RandomPanelFactory = _
  private var rng: Random = _

  override def beforeEach(context: BeforeEach): Unit = {
    rng = new Random(11)
    rand = new RandomPanelFactory(rng)
  }

  test("Generated Panel's class should be in the allowed list of classes") {
    for (_ <- 1 to 10) {
      assert(rand.factoryList.map(x => x.getClass).contains(rand.create().getClass))
    }
  }
  test("Two consecutive calls should produce different instances of Panel") {
    for(_ <- 1 to 10){
      assertNotEquals(rand.create(), rand.create())
    }
  }
}
