package cl.uchile.dcc.citric
package model.factories

/** A factory that creates objects of type T.
 *
 * @tparam T The type of output the factory creates. Factory should be covariant relative to T.
 */
trait Factory[+T] {
  /** Creates a new object according to the factory's type
   *
   * @return A new element of type T or a subtype of T
   */
  def create(): T
}
