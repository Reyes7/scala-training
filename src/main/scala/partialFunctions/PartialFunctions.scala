package partialFunctions

/**
  *
  * https://www.scala-exercises.org/std_lib/partial_functions
  *
  * isDefinedAt - states that this partial function will take on the task
  * apply - what we do if this partial function matches
  */

object PartialFunctions {

  val doubleEvens: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int) = x % 2 == 0

    def apply(v1: Int) = v1 * 2
  }

  val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int) = x % 2 != 0

    def apply(v1: Int) = v1 * 3
  }

  val anotherDoubleEvens: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 => x * 2
  }
  val anotherTripleOdds: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 => x * 3
  }

  val printEven: PartialFunction[Int, String] = {
    case x if (x % 2) == 0 => "Even"
  }
  val printOdd: PartialFunction[Int, String] = {
    case x if (x % 2) != 0 => "Odd"
  }
}
