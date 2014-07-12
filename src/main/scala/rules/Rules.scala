package rules

import board.Board


/**
 * Created by butlem04 on 08/07/2014.
 */
object Rules {

  def apply(x: Int, y: Int, board: Board): Boolean = {

    board.getAliveNeighbours(x ,y) match {

      case 2          => if (board.getCellState(x, y)) true else false
      case 3          => true
      case x if x < 2 => false
      case x if x > 3 => false

      }
  }

}
