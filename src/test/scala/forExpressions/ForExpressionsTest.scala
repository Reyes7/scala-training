package forExpressions

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/for_expressions

*/

class ForExpressionsTest extends FunSuite with Matchers{

  test("can for use for generate permutations ?"){
    val xValues = 1 to 4
    val yValues = 1 to 2

    val coordinates = for {
      x <- xValues
      y <- yValues
    } yield (x, y)

    coordinates(4) should be(3, 1)
  }

  test("filtering by using for test"){
    val nums = List(List(1), List(2), List(3), List(4), List(5))

    val result = for {
      numList <- nums
      num <- numList
      if num % 2 == 0
    } yield num

    result should be (List(2, 4))

    // Which is the same as
    nums.flatMap(numList => numList).filter(_ % 2 == 0) should be(result)

    // or the same as
    nums.flatten.filter(_ % 2 == 0) should be(result)
  }
}
