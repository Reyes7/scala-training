package collections

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/ranges

*/

class RangesTest extends FunSuite with Matchers {

  test("scala ranges test"){
    val firstRange = Range(0, 10)
    val secondRange = 0 until 10

    val second = firstRange(1)
    val last = firstRange.last

    firstRange.size should be (10)
    second should be (1)
    last should be (9)

    (firstRange == secondRange) should be (true)
  }

  test("can I in scala ranges specify increment step ?"){
    val someNumbers = Range(2, 10, 3)

    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be (3)
    second should be (5)
    last should be (8)
  }

  test("can scala range include upper bound value ?"){
    val someNumbers = Range(0, 34).inclusive
    val otherRange = 0 to 34

    someNumbers.contains(34) should be(true)
    (someNumbers == otherRange) should be(true)
  }
}