import board.Board
import org.scalatest.FlatSpec

/**
 * Created by butlem04 on 12/07/2014.
 */
class LifeTest extends FlatSpec {

  "Life tick with empty board " should " return with empty board" in {

    val board = Life.tick(new Board(Array.tabulate(3,3) ((x, y) => (false))))

    val result = new Board(Array.tabulate(3,3) ((x, y) => (false)))

    assert(board.deep == result.deep)

  }


  "Life tick with all alive board " should " return with correct result" in {

    val board = Life.tick(new Board(Array.tabulate(4,4) ((x, y) => (true))))

    val result = Life.tick(new Board(Array.tabulate(4,4) ((x, y) => (false))))

    assert(board.deep == result.deep)

  }


  "Life tick" should " tick through board" in {

    val board = Life.tick(new Board(Array(Array(true, false, true, true),Array(true, false, true, false)
      ,Array(true, false, true, false),Array(true, false, true, true))))

    val result = new Board(Array(Array(false, false, true, false),Array(false, true, false, true)
      ,Array(false, true, false, true),Array(false, false, true, false)))

    assert(board.deep == result.deep)

  }


}
