package collections.traversables

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/traversables
      * https://dzone.com/articles/understanding-foldleft-scala
      * https://coderwall.com/p/4l73-a/scala-fold-foldleft-and-foldright

      * foldLeft or '/:' will combine an operation starting with a seed and combining from the left.
      * foldLeft is defined as: (((init op x1) op x2) op x3) op x4)
      * foldRight or ':\' will combine an operation starting with a seed and combining from the right

      * reduceLeft is similar to foldLeft, except that the seed is the head value
      * reduceRight is similar to foldRight, except that the seed is the last value

*/

class TraversableFoldAndReduceTest extends FunSuite with Matchers{

  private val list = List(5, 4, 3, 2, 1)
  private val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")

  test("foldLeft test"){
    val RESULT = -15

    val result1 = (0 /: list) {
      (`running total`, `next element`) => `running total` - `next element`
    }

    val result2 = list.foldLeft(0) {
      (`running total`, `next element`) => `running total` - `next element`
    }

    val result3 = (0 /: list)(_ - _)

    val result4 = list.foldLeft(0)(_ - _)

    val result5 = ((((0 - 5) - 4) - 3) - 2) - 1

    result1 should be(RESULT)
    result2 should be(RESULT)
    result3 should be(RESULT)
    result4 should be(RESULT)
    result5 should be(RESULT)
  }

  test("foldRight test"){
    val RESULT = 3
    val result1 = (list :\ 0) {
      (`next element`, `running total`) => `next element` - `running total`
    }

    val result2 = list.foldRight(0) { (`next element`, `running total`) =>
      `next element` - `running total`
    }

    val result3 = (list :\ 0)(_ - _)

    val result4 = list.foldRight(0)(_ - _)

    val result5 = 5 - (4 - (3 - (2 - (1 - 0))))

    result1 should be(RESULT)
    result2 should be(RESULT)
    result3 should be(RESULT)
    result4 should be(RESULT)

    /**
      * 5 - 4 + (3 - 2) + (1)
    */
    result5 should be(RESULT)
  }

  test("reduceLeft test"){
    list.reduceLeft {
      _ + _
    } should be(15)

    stringList.reduceLeft {
      _ + _
    } should be("DoReMeFaSoLaTeDo")
  }

  test("reduceRight test"){
    list.reduceRight {
      _ + _
    } should be(15)

    stringList.reduceRight {
      _ + _
    } should be("DoReMeFaSoLaTeDo")
  }

  test("reduce and reverse.reduce test"){
    val intList = List(5, 4, 3, 2, 1)
    intList.reduceRight((x, y) => x - y) should be(3)
    intList.reverse.reduceLeft((x, y) => y - x) should be(3)
    intList.reverse.reduce((x, y) => y - x) should be(3)
  }
}