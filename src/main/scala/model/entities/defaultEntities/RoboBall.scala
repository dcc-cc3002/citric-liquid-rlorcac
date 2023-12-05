package cl.uchile.dcc.citric
package model.entities.defaultEntities

import model.entities.ConcreteWildUnit

/** A RoboBall-type wild unit. Starts with 3 health points, a -1 to attack and evasion, a +1 to defense, and with 2 stars
 *
 */
class RoboBall extends ConcreteWildUnit(3, -1, +1, -1, 2) {

}
