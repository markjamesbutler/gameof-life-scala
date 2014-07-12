package rules

/**
 * Created by butlem04 on 08/07/2014.
 */
class FewerThanTwoNeighboursRule extends Rule {

  override def apply(x: Int, y: Int, board: Board): Boolean = {

    board.getAliveNeighbours(x ,y) < 2

  }

}
