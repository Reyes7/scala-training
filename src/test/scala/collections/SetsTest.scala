package collections

import org.scalatest.{FunSuite, Matchers}

class SetsTest extends FunSuite with Matchers {

  val numbers = Set("one", "two", 3, 4, "five", 6, "seven")

  test("is size of premierLeagueTop set 3 ?"){
    val premierLeagueTop = Set(
      "Manchester United",
      "Chelsea FC",
      "Arsenal"
    )

    premierLeagueTop.size should be (3)
  }

  test("does set contain repetitive values ?"){
    val laLigaTopTwo = Set(
      "Real Madrid",
      "FC Barcelona",
      "Real Madrid"
    )

    laLigaTopTwo.size should be (2)

    val laLigaTopThree = laLigaTopTwo + "Atletico Madrid"

    laLigaTopThree.contains("Atletico Madrid") should be (true)
    laLigaTopThree.size should be (3)

    val laLigaTopOne = laLigaTopTwo -  "Real Madrid"

    laLigaTopOne.contains("Real Madrid") should be (false)
    laLigaTopOne.size should be (1)
  }

  test("does number set in scala contain mixed data types ?"){
    numbers("one") should be (true) // set(x) same as set.contains(x)
    numbers(3) should be (true)
    numbers("four") should be (false)
  }

  test("can I remove multiple values from scala set ?"){
    val numbersLessThenThree = numbers -- List(3, 4, "five")      // -- use for List
    val numbersGreaterThenTwo = numbers - ("one", "two")          //  - use for Tuple

    numbersLessThenThree(3) should be(false)
    numbersLessThenThree("five") should be(false)
    numbersLessThenThree("two") should be(true)
    numbersLessThenThree.size should be(4)

    numbersGreaterThenTwo(3) should be(true)
    numbersGreaterThenTwo("one") should be(false)
    numbersGreaterThenTwo("five") should be (true)
    numbersGreaterThenTwo.size should be(5)
  }

  test("can I extract common part of two sets in scala ?"){
    val numbersX = Set("one", 3, "five")
    val newSet = numbers intersect numbersX

    newSet.equals(Set("one", 3, "five")) should be(true)
    newSet("Iowa") should be (false)

    newSet.size should be (3)
  }

  test("can I join two sets in scala ?"){
    val numbersX = Set("eight", 9, "ten")
    val newSet = numbers union numbersX                             // also use the | operator

    newSet.equals(Set("one", "two", 3, 4, "five", 6, "seven", "eight", 9, "ten")) should be(true)
  }

  test("check set contain another set"){
    val numbersX = Set("one", 3, "five")
    val numbersY = Set(4, "seven", "car")

    numbersX subsetOf numbers should be (true)
    numbersY subsetOf numbers should be (false)
  }

  test("can I extract differences between two sets in scala ?"){
    val numbersX = Set("two", 3, "five", 6)
    val newSet = numbers diff numbersX                            // also use the &~ operator

    newSet.equals(Set("seven", 4, "one")) should be (true)
  }

  test("check order"){
    val numbersX = Set(4, "one", 3, "two", 6, "five", "seven")
    numbers.equals(numbersX) should be (true)
  }
}