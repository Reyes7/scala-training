package collections.traversables

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/traversables

*/

class TraversableConversionTest extends FunSuite with Matchers{

  private val set = Set(4, 6, 7, 8, 9, 13, 14)
  private val list = List(5, 6, 7, 8, 9)

  test("can traversable be converted to array ?"){
    val setToArray = set.toArray
    setToArray.isInstanceOf[Array[Int]] should be(true)
  }

  test("can traversable be converted to list ?"){
    val setToList = set.toList
    val listToList = list.toList

    setToList.isInstanceOf[List[_]] should be(true)
    listToList eq list should be(true)
  }

  test("can traversable be converted to iterable ?"){
    val setToIterable = set.toIterable
    setToIterable.isInstanceOf[Iterable[_]] should be(true)
  }

  test("can traversable be converted to seq ?"){
    val setToSeq = set.toSeq
    val setToIndexedSeq = set.toIndexedSeq

    setToSeq.isInstanceOf[Seq[_]] should be(true)
    setToIndexedSeq.isInstanceOf[IndexedSeq[_]] should be(true)
  }

  test("can traversable be converted to stream ?"){
    val listToStream = list.toStream
    listToStream.isInstanceOf[Stream[_]] should be(true)
    (listToStream take 3) should be(Stream(5, 6, 7))
  }

  test("can traversable be converted to set ?"){
    val listToSet = list.toSet
    listToSet.isInstanceOf[Set[_]] should be(true)
  }

  test("can traversable be converted to map ?"){
    val anotherSet = Set("Phoenix" -> "Arizona", "Austin" -> "Texas")
    val anotherList = List("Phoenix" -> "Arizona", "Austin" -> "Texas")

    val setToMap = anotherSet.toMap
    val listToMap = anotherList.toMap

    setToMap.isInstanceOf[Map[_, _]] should be(true)
    listToMap.isInstanceOf[Map[_, _]] should be(true)
  }

  test("can traversable be converted to String separated by comma ?"){
    val list = List(1, 2, 3, 4, 5)
    list.mkString(",") should be("1,2,3,4,5")
  }

  test("can traversable be converted to String with start and end delimiter separated by comma ?"){
    val list = List(1, 2, 3, 4, 5)
    list.mkString(">", ",", "<") should be(">1,2,3,4,5<")
  }

  test("can traversable be converted to String with filter result ?"){
    val stringBuilder = new StringBuilder()
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    stringBuilder.append("I want all numbers 6-12: ")
    list.filter(it => it > 5 && it < 13).addString(stringBuilder, ",")
    stringBuilder.mkString should be("I want all numbers 6-12: 6,7,8,9,10,11,12")
  }
}
