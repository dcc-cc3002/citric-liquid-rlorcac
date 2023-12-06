package cl.uchile.dcc.citric
package model.randomizer

import model.panels.Panel
import model.panels.factories.{BonusPanelFactory, DropPanelFactory, EncounterPanelFactory, NeutralPanelFactory}

import scala.util.Random

/** Creates `Panels`s on demand, choosing from the default types at random.
 *  Can not create `HomePanel`s as they are bound to a player.
 *
 * @param rng A source of randomness
 */
class RandomPanelFactory(private val rng: Random = new Random())
  extends RandomFactory[Panel](
    List(new BonusPanelFactory, new DropPanelFactory, new EncounterPanelFactory, new NeutralPanelFactory),
    rng
  )
