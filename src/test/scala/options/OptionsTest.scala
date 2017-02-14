package options

import org.scalatest.{FunSuite, Matchers}

//  https://www.scala-exercises.org/std_lib/options
//  https://www.tutorialspoint.com/scala/scala_options.htm
//  http://www.scala-lang.org/api/2.12.x/scala/Option.html

class OptionsTest extends FunSuite with Matchers{

  test("is someValue should have some text ?"){
    val someText = "I am wrapped in something"
    val someValue: Option[String] = Some(someText)
    someValue should be (Some(someText))
  }

  test("is emptyValue should be none ?"){
    val emptyValue: Option[String] = None
    emptyValue should be (None)
  }

  test("when true then function return text ?"){
    val value = maybeItWillReturnSomething(true)
    value getOrElse "No value" should be ("Found value")
  }

  test("when false then function return None ?"){
    val value = maybeItWillReturnSomething(false)
    value getOrElse "No value" should be ("No value")
  }

  test("getOrElse with brackets example"){
    val value = maybeItWillReturnSomething(false)
    value getOrElse {
      "default function"
    } should be("default function")
  }

  test("when true value should not be empty ?"){
    val value = maybeItWillReturnSomething(true)
    value.isEmpty should be(false)
  }

  test("when false value should be empty ?"){
    val value = maybeItWillReturnSomething(false)
    value.isEmpty should be(true)
  }

  test("when Some value could be 20.0 then value also ?"){
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    value should be (20.0)
  }

  test("when Some value could be None then value equals 0.0 ?"){
    val noValue: Option[Double] = None
    val value = noValue match {
      case Some(v) => v
      case None => 0.0
    }
    value should be(0.0)
  }

  test("when number exists then some result should be multiplied ?"){
    val number: Option[Int] = Some(3)
    val result = number.map(_ * 1.5) // return Some object
    result should be (Some(4.5))
  }

  test("when number is none then result should be None ?"){
    val number: Option[Int] = None
    val result = number.map(_ * 1.5)
    result should be(None)
  }

//  fold extract value from Option

  test("when number exists then result should be multiplied ?"){
    val number: Option[Int] = Some(3)
    val result = number.fold(0)(_ * 3)
    result should be(9)
  }

  test("when number is none then result should be 0 ?"){
    val number: Option[Int] = None
    val result = number.fold(0)(_ * 3)
    result should be(0)
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }

}
