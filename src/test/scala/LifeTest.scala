import board.Board
import org.scalatest.FlatSpec

/**
 * Created by butlem04 on 12/07/2014.
 */
class LifeTest extends FlatSpec {

  "Life tick" should " tick through board" in {

    Life.tick(new Board(Array(Array(true, false, true, true),Array(true, false, true, false)
      ,Array(true, false, true, false),Array(true, false, true, true))))

  }

}
