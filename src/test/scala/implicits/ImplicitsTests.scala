package implicits

import java.math.BigInteger

import org.scalatest.{FunSuite, Matchers}
import Implicits.MyPredef._
import Implicits.MySum._
import Implicits.HourlyRate._

/**

      * https://www.scala-exercises.org/std_lib/implicits

*/

class ImplicitsTests extends FunSuite with Matchers{

  test("implicit odd number test"){
    19.isOdd should be (true)
    20.isOdd should be (false)
  }

  test("can I use implicits to convert value's type to another ?"){
    add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9) should be (true)
    add(3, 6) == 9 should be (false)
    add(3, 6) == Int2BigIntegerConvert(9) should be (true)
    add(3, 6) == (9: BigInteger) should be (true)
    add(3, 6).intValue() == 9 should be (true)
  }

  test("implicit function parameters test"){
    howMuchCanIMake_?(8) should be(240)
  }

  test("can implicit function contain list of implicits ?"){
    howMuchCanIMakeWithCurrency_?(30) should be("900 Dollars")
    howMuchCanIMakeWithDefaultParams_?(30, 95) should be("2850 Dollars")
  }
}
