package rules

/**
 * Created by butlem04 on 08/07/2014.
 */
abstract class Rule {

  def apply(x: Int, y: Int, board: Board):Boolean

}
