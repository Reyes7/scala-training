package collections

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/iterables

*/

class IterablesTest extends FunSuite with Matchers{

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)

  test("iterator example"){
    val iterator = list.iterator
    if (iterator.hasNext) {
      iterator.next should be(3)
    }
  }

  test("can iterator be used for grouping values ?"){
    val iterator = list grouped 3

    iterator.next() should be(List(3, 5, 9))
    iterator.next() should be(List(11, 15, 19))
    iterator.next() should be(List(21, 24, 32))
  }

  test("can iterator be used for sliding values ?"){
    val iterator = list sliding 3

    iterator.next() should be(List(3, 5, 9))
    iterator.next() should be(List(5, 9, 11))
    iterator.next() should be(List(9, 11, 15))
  }

  test("can iterator be used for sliding values like vector ?"){
    val iterator = list sliding (3, 2)
    iterator.next() should be(List(3, 5, 9))
    iterator.next() should be(List(9, 11, 15))
    iterator.next() should be(List(15, 19, 21))
  }

  test("can I retrieves last 3 elements of an Iterable ?"){
    (list takeRight 3) should be(List(21, 24, 32))
  }

  test("can I drop last 3 elements ?"){
    (list dropRight 3) should be(List(3, 5, 9, 11, 15, 19))
  }

  test("can I zip two iterables ?"){
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann", "Stella")
    (xs zip ys) should be(List((3, "Bob"), (5, "Ann"), (9, "Stella")))
  }

  test("can I zip two iterables when these are not the same size ?"){
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")

    (xs zip ys) should be(List((3, "Bob"), (5, "Ann")))
    (xs zipAll (ys, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (9, "?")))

    val xt = List(3, 5)
    val yt = List("Bob", "Ann", "Stella")
    (xt zipAll (yt, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (-1, "Stella")))
  }

  test("can I zip iterables with indexes ?"){
    val xs = List("Manny", "Moe", "Jack")
    xs.zipWithIndex should be(List(("Manny", 0), ("Moe", 1), ("Jack", 2)))
  }

  test("Are function sameElements crazy ? :)"){
    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    (xs sameElements ys) should be (true)

    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    (xt sameElements yt) should be (false)

    val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
    val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
    (xs1 sameElements ys1) should be (true)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
    (xt1 sameElements yt1) should be (false)
  }
}
