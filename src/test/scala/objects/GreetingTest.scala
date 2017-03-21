package objects

import org.scalatest.{FunSuite, Matchers}

class GreetingTest extends FunSuite with Matchers{

  test("in english greeting is Hi ?"){
    Greeting.english should be ("Hi")
  }

  test("in spanish greeting is Hola ?"){
    Greeting.espanol should be ("Hola")
  }

  test("does objects reference is the same when I equate used = ?"){
    val x = Greeting
    val y = x

    x eq y should be(true) // eq checks for reference
  }

  test("does objects reference is the same when I equate two objects with the same object"){
    val x = Greeting
    val y = Greeting

    x eq y should be(true)
  }
}
