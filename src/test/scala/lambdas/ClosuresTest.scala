package lambdas

import org.scalatest.{FunSuite, Matchers}

class ClosuresTest extends FunSuite with Matchers{ // https://www.scala-exercises.org/std_lib/higher_order_functions

  test("does my closure increment value of 3 ?"){
    val result = Closures.closure(10)
    result should be (13)
  }

  test("can I composite closures ?"){
    val result = Closures.summation(10, Closures.closure)
    result should be (13)
  }

  test("does function addWithoutSyntaxSugar return another function ?") {
    Closures.addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be (true)
  }

  test("does function addWithoutSyntaxSugar sum values ?") {
    Closures.addWithoutSyntaxSugar(2)(3) should be (5)
  }

  test("does function fiveAdder return 10 ?") {
    Closures.fiveAdder(5) should be (10)
  }

  test("does function addWithSyntaxSugar also return another function ?"){
   Closures.addWithSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be (true)
  }

  test("does function addWithoutSyntaxSugar also sum values ?") {
    Closures.addWithoutSyntaxSugar(2)(3) should be (5)
  }

  test("does twoAdder function return 4 ?"){
    Closures.twoAdder(2) should be (4)
  }

  test("does function addWithSyntaxSugar is instance of Function1 ?"){
    Closures.addWithSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be (true)
  }

  test("does function makeUpper make all strings in list upper ?"){
    Closures.makeUpper(List("abc", "xyz", "123")) should be(List("ABC", "XYZ", "123"))
  }

  test("does function makeWhatEverYouLike make all strings in list lower ?"){
    Closures.makeWhatEverYouLike(List("ABC", "XYZ", "123"), {
      x => x.toLowerCase
    }) should be(List("abc", "xyz", "123"))
  }

  //a map method applies the function to each element of a list

  test("can I fill map and length functions to get length of strings in list ?"){
    List("Scala", "Erlang", "Clojure") map {
      _.length
    } should be(List(5, 6, 7))
  }
}
