package options

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/options

      * https://www.tutorialspoint.com/scala/scala_options.htm
      * http://www.scala-lang.org/api/2.12.x/scala/Option.html
  *
*/

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

  test("does function maybeItWillReturnSomething return Found value when it should be called with true ?"){
    val value = maybeItWillReturnSomething(true)
    value getOrElse "No value" should be ("Found value")
  }

  test("does function getOrElse return No value when another function return None ?"){
    val value = maybeItWillReturnSomething(false)
    value getOrElse "No value" should be ("No value")
  }

  test("can I use function getOrElse with brackets ?"){
    val value = maybeItWillReturnSomething(false)
    value getOrElse {
      "default function"
    } should be("default function")
  }

  test("can I use function isEmpty to check value is None ?"){
    val value = maybeItWillReturnSomething(false)
    value.isEmpty should be(true)
  }

  test("can I use function Some to get value when it exists ?"){
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    value should be (20.0)
  }

  test("can I use function map over option to multiply value when it exist ?"){
    val number: Option[Int] = Some(3)
    val result = number.map(_ * 1.5) // return Some object
    result should be (Some(4.5))
  }

  /**
      * fold extract value from Option
  */

  test("can I use function fold to multiply option value ?"){
    val number: Option[Int] = Some(3)
    val result = number.fold(0)(_ * 3)
    result should be(9)
  }

  test("when option should be None then fold function return 0 ?"){
    val number: Option[Int] = None
    val result = number.fold(0)(_ * 3)
    result should be(0)
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }
}
