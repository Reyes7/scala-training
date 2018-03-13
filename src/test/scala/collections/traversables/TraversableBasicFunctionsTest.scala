package collections.traversables

import org.scalatest.{FunSuite, Matchers}

import scala.collection.immutable.Stream.cons

/**

      * https://www.scala-exercises.org/std_lib/traversables

*/

class TraversableBasicFunctionsTest extends FunSuite with Matchers{

  /**
      * The methods involved can be applied to each other in a different type. ++ appends two Traversables together.
      * The resulting Traversable is the same type of the first element.
  */

  test("append traversables test") {
    val set = Set(1, 9, 10, 22)
    val list = List(3, 4, 5, 10)

    val appendListToSet = set ++ list
    val appendSetToList = list ++ set

    appendListToSet.size should be(7)
    appendListToSet.isInstanceOf[Set[_]] should be (true)
    appendListToSet.isInstanceOf[List[_]] should be (false)

    appendSetToList.size should be(8)
    appendSetToList.isInstanceOf[List[_]] should be (true)
    appendSetToList.isInstanceOf[Set[_]] should be (false)
  }

  /**
      * sum will add all the elements,
      * product will multiply,
      * min would determine the smallest element, and max the largest
  */

  test("traversables basic function test"){
    val list = List(5, 4, 3, 2, 1)

    list.sum should be(15)
    list.product should be(120)
    list.max should be(5)
    list.min should be(1)
  }

  /**
      * foreach will apply a function to all elements of a Traversable, but unlike the map function,
      * it will not return anything since the return type is Unit - an equivalent to a void return type in Java/C++
  */

  test("foreach test") {
    val list = List(4, 6, 7, 8, 9, 13, 14)
    list.foreach(num => println(num * 4))
    list should be(List(4, 6, 7, 8, 9, 13, 14))
  }

  /**
      * find will locate the first item that matches the predicate p as Some, or None if an element is not found
  */

  test("find test") {
    val list = List(10, 19, 45, 1, 22)
    val anotherList = List(4, 8, 16)

    list.find(_ % 2 != 0) should be(Some(19))
    anotherList.find(_ % 2 != 0) should be(None)
  }

  /**
      * filter will take out all elements that don't satisfy a predicate. (An Array is also Traversable.)
      * filterNot will take out all elements that satisfy a predicate
  */

  test("filter test") {
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

    array.filter(_ < 100) should be(Array(87, 44, 5, 4, 10, 39))
    array.filterNot(_ < 100) should be(Array(200, 100))
  }

  /**
      * hasDefiniteSize will return true if the traversable has a finite end, otherwise false
  */

  test("checking if traversable is not empty test") {
    val map = Map("Phoenix" -> "Arizona", "Austin" -> "Texas")
    val set = Set()
    val stream = cons(0, cons(1, Stream.empty))

    map.isEmpty should be(false)
    set.isEmpty should be(true)

    map.nonEmpty should be(true)
    set.nonEmpty should be(false)

    map.size should be(2)
    map.hasDefiniteSize should be(true)
    stream.hasDefiniteSize should be(false)
  }

  /**
      * forall will determine if a predicate is valid for all members of a Traversable
  */

  test("forall test"){
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list forall (_ < 100)
    result should be(false)
  }

  /**
      * exists will determine if a predicate is valid for some members of a Traversable
  */

  test("exists test"){
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list exists (_ < 100)
    result should be(true)
  }

  /**
      * count will count the number of elements that satisfy a predicate in a Traversable
  */

  test("count test"){
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list count (_ < 100)
    result should be(6)
  }
}