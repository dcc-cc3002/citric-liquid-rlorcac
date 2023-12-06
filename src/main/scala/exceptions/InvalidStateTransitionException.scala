package cl.uchile.dcc.citric
package exceptions

/**
 * Custom exception to signal an invalid state transition.
 *
 * @example To throw the exception from state "PlayerTurn" to state "Combat":
 * {{{
 *   throw new InvalidStateTransitionException("PlayerTurn", "Combat")
 *   // => InvalidStateTransitionException: An invalid state transition was encountered -- Cannot transition from PlayerTurn to Combat.
 * }}}
 * @example To throw the exception from state "MainLoop" to states "Recovery" and "PlayerMovement"
 * {{{
 *   throw new InvalidStateException("MainLoop", "Recovery | PlayerMovement")
 *   // => InvalidStateException: An invalid state transition was encountered -- Cannot transition from MainLoop to Recovery | PlayerMovement.
 * }}}
 *
 * @param state1 The name of the state the transition starts at
 * @param state2 The name(s) of the state(s) the transition ends at
 *
 * @author [[https://github.com/rlorcac/ Raimundo Lorca Correa]]
 */
class InvalidStateTransitionException(state1: String, state2: String) extends Exception(s"An invalid state transition was encountered -- Cannot transition from $state1 to $state2.")
