import board.Board
import org.scalatest.FlatSpec
import rules.LifeRules

/**
 * Created by butlem04 on 08/07/2014.
 */
class LifeRulesTest extends FlatSpec {

  val rule = new LifeRules

  "Life Rules" should " pass with two neighbours and alive cell." in {
    test(Array(Array(true, false, false),Array(false, true, false),Array(false, false, true)), true)
  }

  "Life Rules" should " pass with three neighbours and alive cell." in {
    test(Array(Array(true, false, false),Array(true, true, true),Array(false, false, false)), true)
  }

  "Life Rules" should " pass with one neighbour and alive cell.." in {
    test(Array(Array(false, false, false),Array(true, true, false),Array(false, false, false)), false)
  }

  "Life Rules" should " fail with four neighbour and alive cell." in {
    test(Array(Array(true, true, true),Array(true, true, false),Array(false, false, false)), false)
  }

  "Life Rules" should " pass with three neighbour and dead cell." in {
    test(Array(Array(true, true, true),Array(false, false, false),Array(false, false, false)), true)
  }

  "Life Rules" should " fail with zero neighbour and dead cell." in {
    test(Array(Array(false, false, false),Array(false, false, false),Array(false, false, false)), false)
  }

  "Life Rules" should " fail with one neighbours and dead cell" in {
    test(Array(Array(false, true, false),Array(false, false, false),Array(false, false, false)), false)
  }

  "Life Rules" should " fail with two neighbours and dead cell" in {
    test(Array(Array(false, true, true),Array(false, false, false),Array(false, false, false)), false)
  }

  "Life Rules" should " fail with four neighbours and dead cell" in {
    test(Array(Array(true, true, true),Array(true, false, false),Array(false, false, false)), false)
  }

  def test(array: Array[Array[Boolean]], result: Boolean) {

    val board = new Board(array)

    assert(result == rule.apply(1,1 ,board))

  }

}
