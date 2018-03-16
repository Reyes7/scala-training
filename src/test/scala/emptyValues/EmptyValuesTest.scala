package emptyValues

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/empty_values

*/

class EmptyValuesTest extends FunSuite with Matchers {

  /**
      * Nil is just an empty list, exactly like the result of List(). It is of type List[Nothing]
  */

  test("Nil test"){
    List() === Nil shouldBe true
  }

  /**
      * None is the counterpart to Some, used when you're using Scala's Option class to help avoid null references.
      * === - equals
  */

  test("None test"){
    None === None shouldBe true
  }

  test("should None be identical to None ?"){
    None eq None shouldBe true
  }

  test("can None be converted to a String ?"){
    assert(None.toString === "None")
  }

  test("can None be converted to an empty list ?"){
    None.toList === Nil shouldBe true
  }

  test("is None considered empty ?"){
    assert(None.isEmpty === true)
  }

  test("can None be cast to Any, AnyRef or AnyVal ?"){
    None.asInstanceOf[Any] === None shouldBe true
    None.asInstanceOf[AnyRef] === None shouldBe true
    None.asInstanceOf[AnyVal] === None shouldBe true
  }

  test("can None be used with Option instead of null references ?"){
    val optional: Option[String] = None

    assert(optional.isEmpty === true)
    assert(optional === None)
  }

  test("is Some the opposite of None for Option types ?"){
    val optional: Option[String] = Some("Some Value")

    assert((optional == None) === false, "Some(value) should not equal None")
    assert(optional.isEmpty === false, "Some(value) should not be empty")
  }

  test("can Option.getOrElse be used to provide a default in the case of None ?"){
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None

    assert(optional.getOrElse("No Value") === "Some Value", "Should return the value in the option")
    assert(optional2.getOrElse("No Value") === "No Value", "Should return the specified default value")
  }
}
