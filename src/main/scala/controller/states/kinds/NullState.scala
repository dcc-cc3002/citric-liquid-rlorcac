package cl.uchile.dcc.citric
package controller.states.kinds

import controller.states.AbstractGameState

import cl.uchile.dcc.citric.controller.GameController

/** Every transition from this state fails for testing purposes.
 *
 * @param controller A game controller used for testing.
 */
class NullState(controller: GameController) extends AbstractGameState("Null", controller)
