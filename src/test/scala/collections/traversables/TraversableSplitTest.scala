package collections.traversables

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/traversables

      * splitAt, span and partition will split a Traversable at a position, returning a 2 product Tuple.

*/

class TraversableSplitTest extends FunSuite with Matchers{

  private val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

  /**
      * splitAt is also defined as (xs take n, xs drop n)
  */

  test("splitAt test"){
    val result = array splitAt 3

    result._1 should be(Array(87, 44, 5))
    result._2 should be(Array(4, 200, 10, 39, 100))
  }

  /**
      * span is also defined as (xs takeWhile p, xs dropWhile p)
  */

  test("span test"){
    val result = array span (_ < 100)

    result._1 should be(Array(87, 44, 5, 4))
    result._2 should be(Array(200, 10, 39, 100))
  }

  /**
      * The left-hand side contains the elements satisfied by the predicate whereas the right hand side contains the rest of the elements.
      * partition is also defined as (xs filter p, xs filterNot p)
  */

  test("partition test"){
    val result = array partition (_ < 100)

    result._1 should be(Array(87, 44, 5, 4, 10, 39))
    result._2 should be(Array(200, 100))
  }
}