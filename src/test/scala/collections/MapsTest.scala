package collections

import java.util.NoSuchElementException

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/maps

*/

class MapsTest extends FunSuite with Matchers {

  val myMap = Map(
    "MI" -> "Michigan",
    "OH" -> "Ohio",
    "WI" -> "Wisconsin",
    "IA" -> "Iowa"
  )

  test("does size of myMap is 4 ?"){
    myMap.size should be (4)
  }

  test("can I concatenate maps using + ?"){
    val newMap = myMap + ("new" -> "Value")
    newMap.contains("new") should be (true)
  }

  test("can I put to Map multiple identical pairs"){
    val newMap = myMap + ("MI" -> "Michigan")
    newMap.size shouldNot be (5)
    newMap.size should be (4)
  }

  test("can I convert values of myMap to list ?"){
    val mapValues = myMap.values
    mapValues.size should be (4)
    mapValues.head should be ("Michigan")
    mapValues.last should be ("Iowa")
  }

  test("is value for key MI - Michigan and for WI - Wisconsin ?"){
    myMap("MI") should be ("Michigan")
    myMap("WI") should be ("Wisconsin")
  }

  test("can I put many values for one key ?"){
    val films = Map(
      "MI" -> "Mission Impossible",
      "TM" -> "The Matrix",
      "SI" -> "Shutter Island",
      "MI" -> "Mission Impossible 2"
    )

    val mapValues = films.values
    mapValues.size should be (3)
    films("MI") should be ("Mission Impossible 2")
  }

  test("can map contain mixed type of keys"){
    val mixedTypeMap = Map(
      1 -> "one",
      "Month" -> "June"
    )

    mixedTypeMap(1) should be ("one")
    mixedTypeMap("Month") should be ("June")
  }

  test("can I put default value to scala map"){
    val newMap = myMap
    intercept[NoSuchElementException]{
      newMap("TX")
    }

    newMap.getOrElse("TX", "missing data") should be ("missing data")

    val films = Map(
      "MI" -> "Mission Impossible",
      "TM" -> "The Matrix"
    ) withDefaultValue "missing data"

    films("TX") should be ("missing data")
  }

  test("can I remove one element from scala map"){
    val newMap = myMap - "MI"
    newMap.size should be (3)
    newMap.contains("MI") should be (false)
  }

  test("can I remove multiple elements from scala map by list"){
    val newMap = myMap -- List("MI", "IA")
    newMap.size should be (2)
    newMap.contains("MI") should be (false)
    newMap.contains("IA") should be (false)
  }

  test("can I remove multiple elements from scala map by tuple"){
    val newMap = myMap - ("OH", "WI") // - single operator for tuples
    newMap.size should be (2)
    newMap.contains("OH") should be (false)
    newMap.contains("WI") should be (false)
  }


}