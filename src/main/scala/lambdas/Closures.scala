package lambdas

/**
  *
  * https://www.scala-exercises.org/std_lib/higher_order_functions
  *
  */

object Closures {

  var incrementer = 3

  def summation(x: Int, y: Int => Int) = y(x)

  def closure = (x: Int) => x + incrementer

  /**
    * Function returning another function:
    */

  def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
    new Function1[Int, Int]() {
      def apply(y: Int): Int = x + y
    }
  }

  def fiveAdder: Function1[Int, Int] = addWithoutSyntaxSugar(5)

  /**
    * Function returning another function using an anonymous function:
    */

  def addWithSyntaxSugar(x: Int) = (y: Int) => x + y

  def twoAdder = addWithSyntaxSugar(2)

  /**
    * Function taking another function as a parameter:
    */

  def makeUpper(xs: List[String]) = xs map {
    _.toUpperCase
  }

  def makeWhatEverYouLike(xs: List[String], sideEffect: String => String) = {
    xs map sideEffect
  }
}
