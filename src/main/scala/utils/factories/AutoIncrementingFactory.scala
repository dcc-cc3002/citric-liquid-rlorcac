package cl.uchile.dcc.citric
package utils.factories

/** A class for incrementing ID values
 *
 * @param start The starting value.
 */
abstract class AutoIncrementingFactory[T](start: Int) extends Factory[T] {
  private var value: Int = start

  /** Increments the inner value and returns the next one in the sequence.
   *
   * @return The next value in the sequence
   */
  def next: Int = {
    value = value + 1
    value
  }
}
