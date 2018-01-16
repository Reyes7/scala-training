package functions

import org.scalatest.{FunSuite, Matchers}
import partialFunctions.PartialFunctions

/**
  *
  * https://www.scala-exercises.org/std_lib/partial_functions
  *
  */

class PartialFunctionsTest extends FunSuite with Matchers {

  test("Partial function test") {
    val whatToDo = PartialFunctions.doubleEvens orElse PartialFunctions.tripleOdds //Here we chain the partial functions together

    whatToDo(3) should be(9)
    whatToDo(4) should be(8)
  }

  test("Can I use short syntax in partial functions ?") {
    val whatToDo = PartialFunctions.anotherDoubleEvens orElse PartialFunctions.anotherTripleOdds

    whatToDo(3) should be(9)
    whatToDo(4) should be(8)
  }

  test("Can I add result of another function to result of partial function ?") {
    val addFive = (x: Int) => x + 5
    val whatToDo = PartialFunctions.doubleEvens orElse PartialFunctions.tripleOdds andThen addFive

    whatToDo(3) should be(14)
    whatToDo(4) should be(13)
  }

  test("Can I join two partial functions ?") {
    val whatToDo = PartialFunctions.doubleEvens orElse PartialFunctions.tripleOdds andThen
      (PartialFunctions.printEven orElse PartialFunctions.printOdd)

    whatToDo(3) should be("Odd")
    whatToDo(4) should be("Even")
  }
}
