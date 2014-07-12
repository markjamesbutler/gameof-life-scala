import board.Board
import rules.LifeRules

/**
 * Created by butlem04 on 08/07/2014.
 */
object Life {

  def main() {

     tick(new Board(Array(Array(true, true, true, true),Array(true, false, true, true),Array(true, true, true, true))))

  }

  def tick(board: Board): Board = {

    val array = Array.ofDim[Boolean](board.length, board.length)

    for (i <- 0 to board.length -1 ) {
      for ( j <- 0 to board.length -1) {
        print(" " + board.getCellState(i,j));

        array(i)(j)  = LifeRules.apply(i, j, board)

      }
      println();
    }

    println();

    val secondBoard = new Board(array)

    if (secondBoard.containsAliveCell && secondBoard.deep != board.deep) {
      tick(secondBoard)
    }
    else {
      secondBoard
    }
  }

}
