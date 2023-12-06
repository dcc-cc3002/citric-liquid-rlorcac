package cl.uchile.dcc.citric
package controller.states.kinds

import controller.GameController
import controller.states.AbstractGameState

/** Every transition from this state fails for testing purposes.
 *
 * @param controller A game controller used for testing.
 */
class NullState(controller: GameController) extends AbstractGameState("NullState", controller)
