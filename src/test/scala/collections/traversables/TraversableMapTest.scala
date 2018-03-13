package collections.traversables

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/traversables

*/

class TraversableMapTest extends FunSuite with Matchers{

  private val set = Set(1, 3, 4, 6)
  private val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))

  /**
      * map will apply the given function on all elements of a Traversable and return a new collection of the result.
  */

  test("map test"){
    val setMapResult = set.map(_ * 4)
    setMapResult.lastOption should be(Some(24))
  }

  test("map over nested list test"){
    val listMapResult = list.map(_.map(_ * 4))
    listMapResult should be(List(List(4), List(8, 12, 16), List(20, 24, 28), List(32, 36, 40)))
  }

  /**
      * flatMap will not only apply the given function on all elements of a Traversable,
      * but all elements within the elements and flatten the results.

      * flatMap of Options will filter out all Nones but keep the Somes
  */

  test("flatMap test"){
    val list2 = List(1, 2, 3, 4, 5)

    val listFlatMapResult = list.flatMap(_.map(_ * 4))
    val listFlatMapOfOption = list2.flatMap(it => if (it % 2 == 0) Some(it) else None)

    listFlatMapResult should be(List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40))
    listFlatMapOfOption should be(List(2, 4))
  }

  /**
      * flatten will "pack" all child Traversables into a single Traversable
  */

  test("flatten test"){
    list.flatten should be(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }
}
