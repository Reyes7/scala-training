package collections.traversables

import org.scalatest.{FunSuite, Matchers}

import scala.collection.immutable.Stream.cons

/**

      * https://www.scala-exercises.org/std_lib/traversables

      * Traversables are the superclass of List, Array, Map, Set, Stream and more.

*/

class TraversablesTest extends FunSuite with Matchers {

  /**
      * collect will apply a partial function to all elements of a Traversable and return a different collection.
      * two case fragments can be chained to create a more robust result
  */

  test("collect test") {
    val list = List(4, 6, 7, 8, 9, 13, 14)

    val partialFunction1: PartialFunction[Int, Int] = {
      case x: Int if x % 2 == 0 => x * 3
    }

    val partialFunction2: PartialFunction[Int, Int] = {
      case y: Int if y % 2 != 0 => y * 4
    }

    val result1 = list.collect {
      case x: Int if (x % 2 == 0) => x * 3
    }

    val result2 = list.collect(partialFunction1 orElse partialFunction2)

    result1 should be(List(12, 18, 24, 42))
    result2 should be(List(12, 18, 28, 24, 36, 52, 42))
  }

  test("head, tail, last test") {
    val list = List(10, 19, 45, 1, 22)
    val emptyList = List()

    list.head should be(10)
    list.headOption should be(Some(10))
    emptyList.headOption should be(None)

    list.last should be(22)
    list.lastOption should be(Some(22))
    emptyList.lastOption should be(None)

    list.tail should be(List(19, 45, 1, 22))
  }

  /**
      * init will return the rest of the collection without the last
  */

  test("init test") {
    val list = List(10, 19, 45, 1, 22)
    list.init should be(List(10, 19, 45, 1))
  }

  /**
      * Given a from index, and a to index, slice will return the part of the collection including from, and excluding to:
  */

  test("slice test") {
    val list = List(10, 19, 45, 1, 22)
    list.slice(1, 3) should be(List(19, 45))
  }

  /**
      * take will return the first number of elements given
  */

  test("take test") {
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    list.take(3) should be(List(87, 44, 5))

    def streamer(v: Int): Stream[Int] = cons(v, streamer(v + 1))

    val a = streamer(2)
    (a take 3 toList) should be(List(2, 3, 4))

    list.takeWhile(_ < 100) should be(List(87, 44, 5, 4))
  }

  test("drop test") {
    def streamer(v: Int): Stream[Int] = cons(v, streamer(v + 1))

    val a = streamer(2)
    ((a drop 6) take 3).toList should be(List(8, 9, 10))

    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    list.dropWhile(_ < 100) should be(List(200, 10, 39, 100))
  }

  test("group by test"){
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

    val oddAndSmallPartial: PartialFunction[Int, String] = {
      case x: Int if x % 2 != 0 && x < 100 => "Odd and less than 100"
    }

    val evenAndSmallPartial: PartialFunction[Int, String] = {
      case x: Int if x != 0 && x % 2 == 0 && x < 100 => "Even and less than 100"
    }

    val negativePartial: PartialFunction[Int, String] = {
      case x: Int if x < 0 => "Negative Number"
    }

    val largePartial: PartialFunction[Int, String] = {
      case x: Int if x > 99 => "Large Number"
    }

    val zeroPartial: PartialFunction[Int, String] = {
      case x: Int if x == 0 => "Zero"
    }

    val result = array groupBy {
      oddAndSmallPartial orElse
        evenAndSmallPartial orElse
        negativePartial orElse
        largePartial orElse
        zeroPartial
    }

    (result("Even and less than 100") size) should be(3)
    (result("Large Number") size) should be(2)
  }

  /**
      * transpose will take a traversable of traversables and group them by their position in it's own traversable, e.g.:
      * ((x1, x2),(y1, y2)).transpose = (x1, y1), (x2, y2) or
      * ((x1, x2, x3),(y1, y2, y3),(z1, z2, z3)).transpose = ((x1, y1, z1), (x2, y2, z2), (x3, y3, z3))
  */

  test("transpose test"){
    val list = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val list2 = List(List(1), List(4))

    list.transpose should be(List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9)))
    list2.transpose should be(List(List(1, 4)))
  }
}