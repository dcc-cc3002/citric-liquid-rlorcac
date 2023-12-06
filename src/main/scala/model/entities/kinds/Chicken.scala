package cl.uchile.dcc.citric
package model.entities.kinds

import model.entities.ConcreteWildUnit

/** A Chicken-type wild unit. Starts with 3 health points, a -1 to attack and defense, a +1 to evasion, and with 3 stars
 *
 */
class Chicken extends ConcreteWildUnit(3, -1, -1, +1, 3)
