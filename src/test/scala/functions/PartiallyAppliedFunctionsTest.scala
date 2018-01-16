package functions

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/partially_applied_functions

*/

class PartiallyAppliedFunctionsTest extends FunSuite with Matchers{

  private def sum(a: Int, b: Int, c: Int) = a + b + c
  private def multiply(x: Int, y: Int) = x * y

  test("Does function sum work well ?"){
    val sum3 = sum _

    sum3(1, 9, 7) should be (17)
    sum(4, 5, 6) should be (15)
  }

  test("Can partially applied functions replace any number of arguments ?"){
    val sumC = sum(1, 10, _ : Int)

    sumC(4) should be (15)
    sum(4, 5, 6) should be (15)
  }

  /**
      * Currying is a technique to transform a function with multiple parameters into multiple functions which each take one parameter
  */

  test("Currying example"){
    (multiply _).isInstanceOf[Function2[_, _, _]] should be(true)

    val multiplyCurried = (multiply _).curried
    multiply(4, 5) should be(20)
    multiplyCurried(3)(2) should be(6)

    val multiplyCurriedFour = multiplyCurried(4)
    multiplyCurriedFour(2) should be(8)
    multiplyCurriedFour(4) should be(16)
  }

  /**
      * Currying allows you to create specialized versions of generalized functions:
  */

  test("Currying example 2"){
    def customFilter(f: Int => Boolean)(xs: List[Int]) = xs filter f

    def onlyEven(x: Int) = x % 2 == 0
    val xs = List(12, 11, 5, 20, 3, 13, 2)
    customFilter(onlyEven)(xs) should be (List(12, 20, 2))

    val onlyEvenFilter = customFilter(onlyEven) _
    onlyEvenFilter(xs) should be (List(12, 20, 2))
  }
}