package rules

import board.Board


/**
 * Created by butlem04 on 08/07/2014.
 */
class FewerThanTwoNeighboursRule extends Rule {

  override def apply(x: Int, y: Int, board: Board): Boolean = {

    val neighbours = board.getAliveNeighbours(x ,y)

    val cell = board.getCellState(x, y)

    if (cell) {

      System.out.println(neighbours)

      // Any live cell with fewer than two live neighbours dies, as if caused by under-population.
      if (neighbours < 2 ) return false

      // Any live cell with two or three live neighbours lives on to the next generation.
      if (2 == neighbours || neighbours== 3) return true

      // Any live cell with more than three live neighbours dies, as if by overcrowding.
      if (neighbours > 3) return false

      true

    }

    else {

      // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
      if (neighbours == 3) return true

      false

    }

  }

}
