package board

/**
 * Created by butlem04 on 08/07/2014.
 */
class Board(board: Array[Array[Boolean]]) {

  def getCellState(x: Int, y: Int): Boolean = {

    try {

      board.apply(x).apply(y)

    } catch {

      case aioob: ArrayIndexOutOfBoundsException => false
        
    }

  }

  def getAliveNeighbours(x: Int, y: Int): Int = {

    val count = board.flatten.count(s => s == true)

    if (getCellState(x, y)) count - 1
    else count

  }

  def containsAliveCell: Boolean = {
    board.flatten.contains(true)
  }

  def length: Int = {
    board.length
  }

  def deep = {
    board.deep
  }

}
