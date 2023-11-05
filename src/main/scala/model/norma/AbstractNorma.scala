package cl.uchile.dcc.citric
package model.norma

/** An abstract implementation of the general requirements for a Norma object
 *
 */
abstract class AbstractNorma (n: Int) {
  protected val _level: Int = n
  protected var _goal: (String, Int)

  def level: Int = _level
  def goal: (String, Int) = _goal

}
