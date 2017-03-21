package lambdas

import org.scalatest.{FunSuite, Matchers}

class LambdasTest extends FunSuite with Matchers{ // https://www.scala-exercises.org/std_lib/higher_order_functions

  def lambda = {x : Int => x + 1}

  def lambda2 = (x : Int) => x + 1

  val lambda3 = (x : Int) => x + 1

  val lambda4 = new Function1[Int, Int]{
    def apply(x : Int) : Int = x + 1
  }

  def lambda5(x : Int) = x + 1

  test("does above lambdas increment given value ?"){
    val result = lambda(0)
    val result2 = lambda2(1)
    val result3 = lambda3(2)
    val result4 = lambda4(3)

    result should be (1)
    result2 should be (2)
    result3 should be (3)
    result4 should be (4)
  }

  test("does lambda4 increment value ?"){
    val `result1andhalf` = lambda.apply(3)
    result1andhalf should be(4)
  }
}
