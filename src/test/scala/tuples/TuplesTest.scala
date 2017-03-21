package tuples

import java.util.Date
import org.scalatest.{FunSuite, Matchers}

class TuplesTest extends FunSuite with Matchers{

  test("is two tuples the same ?"){
    val tuple1 = (1, "hello", Console)
    val tuple2 = new Tuple3(1, "hello", Console)

    tuple1 should be (tuple2)
  }

  test("is second value in tuple dog ?"){
    val tuple = ("apple", "dog")
    val animal = tuple._2

    animal should be ("dog")
  }

  test("is fifth value in tuple five ?"){
    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._5 should be ("five")
  }

  test("isn't lost values when put Tuple to variable ?"){
    val student = ("Reyes", 26, 5.0)
    val (name, age, gpa) = student

    name should be("Reyes")
    age should be(26)
    gpa should be(5.0)
  }

  test("variables will change places when I use swap function"){
    val tuple = ("apple", 3).swap
    tuple._1 should be(3)
    tuple._2 should be("apple")
  }
}
