package cl.uchile.dcc.citric
package controller

import controller.states.GameState
import controller.states.kinds.{EndGame, PreGame}
import exceptions.InvalidStateTransitionException
import model.entities.Player
import model.panels.Board

import scala.util.Random

/** The main controller of the game
 *
 * @param players The players that will play on the game.
 * @param size The size of the board. Actual size will be `1.min(size) + players.size` as `players.size` Home Panels will be added to give each Player a Home Panel.
 */
class GameController(private var players: List[Player], size: Int) {
  players = Random.shuffle(players)
  for(player <- players){
    player.setController(this)
  }
  private var _chapter: Int = 1
  val board: Board = new Board(players, size)
  var state: GameState = new PreGame(this)
  var gameOver: Boolean = false

  /** Chooses from a list of options at random.
   *
   * @param options A list of options to choose from.
   * @return The number of the chosen option.
   */
  def getInput(options: List[String]): Int = {
    Random.nextInt(options.size)
  }

  /** Gives the current chapter number for the running game.
   *
   * @return
   */
  def chapter: Int = _chapter

  def startGame(): Unit = {
    state.startGame()
    gameOver = false
    _chapter = 1
  }

  /** Ends the game and declares a winner.
   *
   * @param player The player that caused the game to end by winning.
   */
  def endGame(player: Player): Unit = {
    state = new EndGame(this)
    gameOver = true
  }

  protected[controller] def setState(newState: GameState): Unit = {
    state = newState
  }

  def playerTurn(player: Player): Unit = {
    state.startTurn(player)
    var enteredRecovery: Boolean = false
    if(player.currentHp == 0){
      enteredRecovery = true
      state.startRecovery()
    }
    if(player.currentHp == 0){
      state.failRecovery()
    }
    else{
      if(enteredRecovery) state.passRecovery()
      state.rollDie()
      if (player.currentPanel.getWildUnit.nonEmpty) {
        state.startWildUnitCombat(player.currentPanel.getWildUnit.get)
      }
    }
  }

  def turn(): Unit = {
    for(player <- players){
      try{
        playerTurn(player)
      }
      catch{
        case e: InvalidStateTransitionException => println(e.getMessage + ", skipping turn")
      }
      finally{

      }
    }
    _chapter += 1
  }

  /** Makes the game loop until a player wins
   *
   */
  def loop(): Unit = {
    while(!gameOver){
      turn()
    }
  }
}
