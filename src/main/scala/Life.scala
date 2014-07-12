import board.Board
import rules.Rules

/**
 * Created by butlem04 on 08/07/2014.
 */
object Life {

  def tick(board: Board): Board = {

    val array = Array.ofDim[Boolean](board.length, board.length)

    (0 to board.length -1) foreach { x =>
      (0 to board.length -1) foreach { y =>
        array(x)(y) = Rules.apply(x, y, board)
      }
    }

    val secondBoard = new Board(array)

    if (secondBoard.containsAliveCell && secondBoard.deep != board.deep) {
      tick(secondBoard)
    }
    else {
      secondBoard
    }
  }

}
