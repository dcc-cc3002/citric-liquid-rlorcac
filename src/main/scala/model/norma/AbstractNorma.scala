package cl.uchile.dcc.citric
package model.norma


/** An abstract implementation of the general requirements for a Norma object
 *
 * @param _level The level of the `Norma` object
 * @param _goalType The type of goal chosen to reach the next norma level. Legal values: "Victories" | "Stars"
 * @param _goalAmount The amount of `_goalType` required to reach the next norma level
 */
abstract class AbstractNorma (protected val _level: Int,
                              protected val _goalType: String,
                              protected var _goalAmount: Int) extends Norma {
  /** An abstract implementation of the general requirements for a Norma object. Calculates the required amount for the goal based on level and goal type.
   *
   * @param _level The level of the `Norma` object
   * @param _goalType The type of goal chosen to reach the next norma level. Legal values: "Victories" | "Stars"
   */
  def this(_level: Int, _goalType: String) = {
    this(_level, _goalType, 0)
    val goalDict: Map[String, List[Int]] = Map[String, List[Int]]("Stars" -> List(10, 30, 70, 120, 200), "Victories" -> List(1, 3, 6, 10, 14)) // goals for passing from levels 1, 2, 3, 4, 5
    val goalList = goalDict.get(_goalType)
    if(goalList.isEmpty) throw new Exception("Goal type was not within legal values")
    else this._goalAmount = goalList.get.lift(this._level-1).getOrElse(0)
  }

  override def level: Int = _level

  override def goal: String = s"${_goalType}, ${_goalAmount}"

  /** Creates and returns a `Norma` object of the next level if possible.
   *
   * @param nextGoalType The type of goal chosen to reach the next norma level. Legal values: "Victories" | "Stars"
   * @return A `Norma` object of the next level if possible, current object if there is no further level.
   */
  protected def next(nextGoalType: => String): Norma

  override def check(stars: Int, victories: Int, nextGoalType: => String): Norma = {
    val normaMap: Map[String, Int] = Map[String, Int]("Victories" -> victories, "Stars" -> stars)
    val goalProgress = normaMap.getOrElse(_goalType, 0)
    if(goalProgress >= _goalAmount) next(nextGoalType)
    else this
  }
}
