package patterns

import org.scalatest.{FunSuite, Matchers}

class PatternMatchingTests extends FunSuite with Matchers{

  test("Does pattern matching return mixed types ?"){
    val stuff = "blue"

    val myStuff = stuff match {
      case "red"    => println("RED");    "red"
      case "blue"   => println("BLUE");   2
      case "green"  => println("GREEN");  3
      case _ => println(stuff); 0 // case _ represent default option
    }

    myStuff should be(2)
  }

  test("Does pattern matching return complex values ?") {
    val stuff = "blue"

    val myStuff = stuff match {
      case "red"    => (255, 0, 0)
      case "green"  => (0, 255, 0)
      case "blue"   => (0, 0, 255)
      case _ => println(stuff); 0
    }

    myStuff should be(0, 0, 255)
  }

  test("Can pattern matching return complex expressions ?"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", "Papa") => "Papa eating porridge"
      case ("porridge", "Mama") => "Mama eating porridge"
      case ("porridge", "Baby") => "Baby eating porridge"
      case _ => "what?"
    }

    goldilocks(("porridge", "Mama")) should be ("Mama eating porridge")
  }

  test("Can pattern matching match any values when used _ ?"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", _) => "eating"
      case ("chair", "Mama") => "sitting"
      case ("bed", "Baby") => "sleeping"
      case _ => "what?"
    }

    goldilocks(("porridge", "Papa")) should be("eating")
    goldilocks(("chair", "Mama")) should be("sitting")
  }

  test("Can pattern matching substitute parts of expressions ?"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", bear) => bear + " said someone's been eating my porridge"
      case ("chair", bear) => bear + " said someone's been sitting in my chair"
      case ("bed", bear) => bear + " said someone's been sleeping in my bed"
      case _ => "what?"
    }

    goldilocks(("porridge", "Papa")) should be("Papa said someone's been eating my porridge")
    goldilocks(("chair", "Mama")) should be("Mama said someone's been sitting in my chair")
  }

  test("Can I inject value to pattern matching in scala ?"){
    val foodItem = "porridge"

    def goldilocks(expr: Any) = expr match {
      case (`foodItem`, _) => "eating"
      case ("chair", "Mama") => "sitting"
      case ("bed", "Baby") => "sleeping"
      case _ => "what?"
    }

    goldilocks(("porridge", "Papa")) should be("eating")
    goldilocks(("chair", "Mama")) should be("sitting")
    goldilocks(("porridge", "Cousin")) should be("eating")
    goldilocks(("beer", "Cousin")) should be("what?")
  }

  test("Can I define type of parameters pattern matching ?"){
    def patternEquals(i: Int, j: Int) = j match {
      case `i` => true
      case _ => false
    }

    patternEquals(3, 3) should be(true)
    patternEquals(7, 9) should be(false)
    patternEquals(9, 9) should be(true)
  }
}