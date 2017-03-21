package maps

import org.scalatest.{FunSuite, Matchers}

class MapsTest extends FunSuite with Matchers { //https://www.scala-exercises.org/std_lib/maps

  val myMap = Map(
    "MI" -> "Michigan",
    "OH" -> "Ohio",
    "WI" -> "Wisconsin",
    "IA" -> "Iowa"
  )

  test("first test in maps ?"){
    myMap.size should be (4)
  }

}
