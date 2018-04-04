package literal

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/literal_booleans
      * https://www.scala-exercises.org/std_lib/literal_numbers
      * https://www.scala-exercises.org/std_lib/literal_strings

*/

class LiteralTests extends FunSuite with Matchers{

  test("literal booleans test"){
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d

    a should be(true)
    b should be(false)
    c should be(false)
    d should be(true)
    e should be(false)
    f should be(false)
  }

  test("literal integer test"){
    val a = 2
    val b = 31
    val c = 0x30F
    val e = 0
    val f = -2
    val g = -31
    val h = -0x30F

    a should be(2)
    b should be(31)
    c should be(783)
    e should be(0)
    f should be(-2)
    g should be(-31)
    h should be(-783)
  }

  test("literal long test"){
    val a = 2L
    val b = 31L
    val c = 0x30FL
    val e = 0L
    val f = -2l
    val g = -31L
    val h = -0x30FL

    a should be(2L)
    b should be(31L)
    c should be(783L)
    e should be(0L)
    f should be(-2L)
    g should be(-31L)
    h should be(-783L)
  }

  test("literal floating types test"){
    val a = 3.0
    val b = 3.00
    val c = 2.73
    val d = 3f
    val e = 3.22d
    val f = 93e-9
    val g = 93E-9
    val h = 0.0
    val i = 9.23E-9D

    a should be(3.0)
    b should be(3.0)
    c should be(2.73)
    d should be(3f)
    e should be(3.22d)
    f should be(93e-9)
    g should be(93E-9)
    h should be(0.0)
    i should be(9.23E-9D)
  }

  test("are character literals quoted with single quotes ?"){
    val a = 'a'
    val b = 'B'

    a.toString should be("a")
    b.toString should be("B")
  }

  test("can character literals use octal ?"){
    val a = '\141'

    a.toString should be("a")
  }

  test("can character literals use escape sequences ?"){
    val a = '\"'
    val b = '\\'

    a.toString should be("\"")
    b.toString should be("\\")
  }
}