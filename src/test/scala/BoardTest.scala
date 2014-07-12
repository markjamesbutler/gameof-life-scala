import board.Board
import org.scalatest.FlatSpec

/**
 * Created by butlem04 on 08/07/2014.
 */
class BoardTest extends FlatSpec {

  "First element of board with one dead cell" should "be false" in {

    val array = Array(Array(false))
    val board = new Board(array)

    assert(false == board.getCellState(0, 0))

  }

  "Out of bounds cell" should "be false" in {

    val array = Array(Array(false))
    val board = new Board(array)

    assert(false == board.getCellState(1, 0))

  }

  "Number of neighbours for one cell board" should "be zero" in {

    val array = Array(Array(false))
    val board = new Board(array)

    assert(0 == board.getAliveNeighbours(0, 0))

  }

  "Number of neighbours for 3x3 with one neighbour cell board" should "be one" in {

    val array = Array(Array(true, false, false),Array(false, true, false),Array(false, false, false))
    val board = new Board(array)

    assert(1 == board.getAliveNeighbours(0, 0))

  }

  "Number of neighbours for 3x3 with two neighbour cell board" should "be two" in {

    val array = Array(Array(true, true, false),Array(false, true, false),Array(false, false, false))
    val board = new Board(array)

    assert(2 == board.getAliveNeighbours(1, 1))

  }

  "Number of neighbours for 3x3 with all alive cells board" should "be eight" in {

    val array = Array(Array(true, true, true),Array(true, true, true),Array(true, true, true))
    val board = new Board(array)

    assert(8 == board.getAliveNeighbours(1, 1))

  }

}
