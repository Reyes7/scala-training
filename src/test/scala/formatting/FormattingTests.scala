package formatting

import org.scalatest.{FunSuite, Matchers}

class FormattingTests extends FunSuite with Matchers{

  test("Can I inject string into another string in scala ?"){
    val helloMessage = "Hello World :)"
    "Application %s".format(helloMessage) should be ("Application Hello World :)")
  }

  test("Does format function return string representation for char ?"){
    val a = 'a'
    val b = 'B'

    "%c".format(a) should be("a")
    "%c".format(b) should be("B")
  }

  test("Does formatting in scala recognize escape character ?"){
    val unicodeA = '\u0061'
    val octalA = '\141'
    val escape = '\"'
    val escape2 = '\\'

    "%c".format(unicodeA) should be("a")
    "%c".format(octalA) should be("a")
    "%c".format(escape) should be("\"")
    "%c".format(escape2) should be("\\")
  }

  test("Can I inject integer values into string in scala ?"){
    val beerQuantity = 150
    "%d bottles of beer on the wall" format beerQuantity - 100 should be("50 bottles of beer on the wall")
  }

  test("Can I mix of inject types into string in scala ?"){
    val quantity = 150
    val drink = "beer"

    "%d bottles of %s on the wall".format(quantity - 100, drink) should be("50 bottles of beer on the wall")
  }
}
