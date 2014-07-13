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

  def getNeighbours(x: Int, y: Int): Array[Array[Boolean]] = {

    val array = Array.ofDim[Boolean](3, 3)

    (-1 to 1) foreach { i =>
      (-1 to 1) foreach { j =>

          array(i + 1)(j + 1) = getCellState(x + i, y + j)

      }
    }

    array
  }

  def getAliveNeighbours(x: Int, y: Int): Int = {

    var count = 0

    getNeighbours(x, y).map(_.map(

      if (_) count += 1)

    )

    if (board.apply(x).apply(y)) count - 1
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

  def getArray(): Array[Array[Boolean]] = {
    board
  }

}
