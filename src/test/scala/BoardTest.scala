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

    val array = Array.tabulate(3,3) ((x, y) => (true))
    val board = new Board(array)

    assert(8 == board.getAliveNeighbours(1, 1))

  }

  "Number of neighbours for 4x4 with all alive cells board" should "be eight" in {

    val array = Array.tabulate(4,4) ((x, y) => (true))
    val board = new Board(array)

    assert(8 == board.getAliveNeighbours(1, 1))

  }

  "containsAliveCell" should "return false with dead board" in {

    val array = Array.tabulate(3,3) ((x, y) => (false))
    val board = new Board(array)

    assert(false == board.containsAliveCell)

  }

  "containsAliveCell" should "return false with alive board" in {

    val array = Array.tabulate(3,3) ((x, y) => (true))
    val board = new Board(array)

    assert(true == board.containsAliveCell)

  }

  "containsAliveCell" should "return false with single alive cell in board" in {

    val array = Array(Array(false, false, false),Array(false, false, false),Array(false, false, true))
    val board = new Board(array)

    assert(true == board.containsAliveCell)

  }

  "length" should "return with correct value" in {

    val array = Array.tabulate(3,3) ((x, y) => (true))
    val board = new Board(array)

    assert(3 == board.length)

  }

  "getNeighbours" should "be empty for one cell board" in {

    val array = Array(Array(false))
    val neighbours = Array.tabulate(3,3) ((x, y) => (false))
    val board = new Board(array)

    assert(neighbours.deep == board.getNeighbours(0, 0).deep)

  }


  "getNeighbours" should "return neighbours for 2x2 board" in {

    val array = Array(Array(true, true),
      Array(true, false))

    val neighbours = Array(Array(false, false, false),
                           Array(false, true, true),
                           Array(false, true, false))

    val board = new Board(array)

    assert(neighbours.deep == board.getNeighbours(0, 0).deep)

  }

  "getNeighbours" should "return neighbours for 3x3 board" in {

    val array = Array.tabulate(3,3) ((x, y) => (false))
    val neighbours = Array.tabulate(3,3) ((x, y) => (false))
    val board = new Board(array)

    assert(neighbours.deep == board.getNeighbours(0, 0).deep)

  }

  "getNeighbours" should "return neighbours for 4x4 board" in {

    val array = Array.tabulate(4,4) ((x, y) => (false))
    val neighbours = Array.tabulate(3,3) ((x, y) => (false))
    val board = new Board(array)

    assert(neighbours.deep == board.getNeighbours(0, 0).deep)

  }

  "getNeighbours" should "return correct neighbours" in {

    val array = Array(Array(true, true, false, true),
                      Array(false, true, false, true),
                      Array(false, false, false, true),
                      Array(false, false, false, true))

    val neighbours = Array(Array(true, true, false),Array(false, true, false),Array(false, false, false))
    val board = new Board(array)

    assert(neighbours.deep == board.getNeighbours(1, 1).deep)

  }

}
