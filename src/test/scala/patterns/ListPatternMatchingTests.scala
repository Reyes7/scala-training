package patterns

import org.scalatest.{FunSuite, Matchers}

class ListPatternMatchingTests extends FunSuite with Matchers{

  test("Can I match elements in scala on lists ?") {
    val secondElement = List(1, 2, 3) match {
      case x :: xs => xs.head              // x -> head, xs -> tail
      case _ => 0
    }

    val secondElementFromAnotherWay = List(1, 2, 3) match {
      case x :: y :: xs => y               // x -> first element, y -> second element, xs -> rest of list.
      case _ => 0
    }

    secondElement should be(2)
    secondElementFromAnotherWay should be(2)
  }

  test("Can I separate elements from list with one element ?"){
    val firstElement = List(1) match {
      case x :: y :: xs => y              // it work on list with two or more items
      case _ => 0
    }

    firstElement should be(0)
  }

  test("Is it possible to match more elements then list contains ?"){
    val l = List(1, 2, 3) match {
      case x :: y :: z :: tail => tail    // if a pattern is exactly one element longer than a List, it extracts the final Nil
      case _ => 0
    }

    l == Nil should be (true)
  }

  test("Is it possible to mach existing element to nil ?"){
    val r = List(1, 2, 3) match {
      case x :: y :: Nil => y              // only matches a list with exactly two items
      case _ => 0
    }

    r should be(0)
  }
}
