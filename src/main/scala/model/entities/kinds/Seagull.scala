package cl.uchile.dcc.citric
package model.entities.kinds

import model.entities.ConcreteWildUnit

/** A Seagull-type wild unit. Starts with 3 health points, a -1 to defense and evasion, a +1 to attack, and with 2 stars
 *
 */
class Seagull extends ConcreteWildUnit(3, +1, -1, -1, 2)
