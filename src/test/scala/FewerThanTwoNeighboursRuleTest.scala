import board.Board
import org.scalatest.FlatSpec
import rules.FewerThanTwoNeighboursRule

/**
 * Created by butlem04 on 08/07/2014.
 */
class FewerThanTwoNeighboursRuleTest extends FlatSpec {

  val rule = new FewerThanTwoNeighboursRule

  "Fewer Than Two Neighbours Rule" should " pass with two neighbours." in {

    val array = Array(Array(true, false, false),Array(false, true, false),Array(false, false, true))

    val board = new Board(array)

    assert(true == rule.apply(1,1 ,board))

  }

  "Fewer Than Two Neighbours Rule" should " pass with three neighbours." in {

    val array = Array(Array(true, false, false),Array(true, true, true),Array(false, false, false))

    val board = new Board(array)

    assert(true == rule.apply(1,1 ,board))

  }

  "Fewer Than Two Neighbours Rule" should " pass with one neighbour." in {

    val array = Array(Array(false, false, false),Array(true, true, false),Array(false, false, false))

    val board = new Board(array)

    assert(false == rule.apply(1,1 ,board))

  }

  "Fewer Than Two Neighbours Rule" should " fail with four neighbour." in {

    val array = Array(Array(true, true, true),Array(true, true, false),Array(false, false, false))

    val board = new Board(array)

    assert(false == rule.apply(1,1 ,board))

  }

  "Fewer Than Two Neighbours Rule" should " pass with three neighbour and dead cell" in {

    val array = Array(Array(true, true, true),Array(false, false, false),Array(false, false, false))

    val board = new Board(array)

    assert(true == rule.apply(1,1 ,board))

  }

}
