package collections

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/sequences_and_arrays

*/

class ArraysAndSequencesTest extends FunSuite with Matchers{

  private val list = List(1, 2, 3)
  private val arr = list.toArray
  private val seq = arr.toSeq

  test("list to array conversion test"){
    arr should equal(Array(1, 2, 3))
  }

  test("list to sequence conversion test"){
    val convertedList = seq.toList
    convertedList should equal(List(1, 2, 3))
  }

  test("can I create sequence by using for ?"){
    val s = for (v <- 1 to 4) yield v
    s.toList should be(List(1, 2, 3, 4))
  }

  test("can I create sequence by using for with filter expression ?"){
    val s = for (v <- 1 to 10 if v % 3 == 0) yield v
    s.toList should be(List(3, 6, 9))
  }

  test("can I filter sequence by using predicate ?"){
    val s = Seq("hello", "to", "you")
    val filtered = s.filter(_.length > 2)
    filtered should be (Seq("hello", "you"))
  }

  test("can I filter array by using predicate ?"){
    val a = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    filtered should be (Array("hello", "again"))
  }

  test("can I map values in sequence ?"){
    val s = Seq("hello", "world")
    val r = s map {
      _.reverse
    }

    r should be(List("olleh", "dlrow"))
  }
}