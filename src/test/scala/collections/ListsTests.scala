package collections

import org.scalatest.{FunSuite, Matchers}

class ListsTests extends FunSuite with Matchers { // https://www.scala-exercises.org/std_lib/lists

  val list1 = List(1, 2, 3)
  val list2 = List(1, 2, 3)
  val list3: List[String] = Nil
  val list4: List[Int] = Nil
  val largeList = List(1, 3, 5, 7, 9)

  test("is two lists the same ?"){
    (list1 eq list2) should be (false)   // eq tests identity (same object)
  }

  test("does two lists have the same content ?"){
    (list1 == list2) should be (true)  // == tests equality (same content)
  }

  test("does comparison undeclared lists are Nil ?"){
    (list3 eq Nil) should be (true)
    (list3 == Nil) should be (true)
    (list3 == list4) should be (true)
    (list3 eq list4) should be (true)
  }

  test("is two lists the same test 2 ?"){
    list1 should equal(List(1,2,3))
  }

  test("does accessing to list1 over headOption give 1 and over tail 2 and 3 ?"){
    list1.headOption should equal(Some(1)) // Accessing List via head is unsafe and may result in a IndexOutOfBoundsException
    list1.tail should equal(List(2, 3))
  }

  test("is second element in largeList 3 ?"){
    largeList(1) should equal(3)
  }

  test("is length of largeList 5 ?"){
    largeList.length should equal(5)
  }

  test("is reverse of largeList 9 7 5 3 1 ?"){
    largeList.reverse should equal(List(9, 7, 5, 3, 1))
  }

  test("can I use map function to power numbers in list ?"){
    largeList.map {x => x * x} should equal(List(1, 9, 25, 49, 81)) // map a function to power the numbers over the list
  }

  test("can I use filter function to get only numbers mod 3 ?"){
    largeList.filter { v => v % 3 == 0 } should equal(List(3, 9)) // filter any values divisible by 3 in the list
  }

  test("can I use map function to multiply numbers in list ?"){
    list1.map { _ * 2 } should equal(List(2, 4, 6))
  }

  test("can I use filter function to get only even numbers from list ?"){
    list1.filter { _ % 2 == 0 } should equal(List(2))
  }

  test("can I change { } to ( ) in map function to multiply numbers in list ?"){
    list1.map ( _ * 2 ) should equal(List(2, 4, 6))
  }

  test("can I change { } to ( ) in filter function to get only not even numbers from list ?"){
    list1.filter ( _ % 2 != 0 ) should equal(List(1, 3))
  }

  test("can I use reduceLeft to perform mathematical operations ?"){ // Lists can be *reduced* with a mathematical operation
    largeList.reduceLeft(_ + _) should equal(25)
    largeList.reduceLeft(_ * _) should equal(945)
  }

  test("can I use foldLeft to perform mathematical operations from given index in list ?"){ // foldLeft is like reduce, but with an explicit starting value
    largeList.foldLeft(0)(_ + _) should equal(25)
    largeList.foldLeft(10)(_ + _) should equal(35)
    largeList.foldLeft(1)(_ * _) should equal(945)
    largeList.foldLeft(0)(_ * _) should equal(0)
  }

  test("can I create list from given range ?"){
    val listFromRange = (1 to 5).toList
    listFromRange should be (List(1, 2, 3, 4, 5))
  }

  test("can I prepend elements to list to get new list ?"){
    val a = List(1, 3, 5, 7)
    0 :: a should be (List(0, 1, 3, 5, 7))
  }

  test("can I concatene lists using ::: ?"){
    val head = List(1, 3)
    val tail = List(5, 7)

    head ::: tail should be (List(1, 3, 5, 7))
    head ::: Nil should be (List(1, 3))
  }

  test("can I create list from given tails ?"){
    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b

    a should be (List(1,2,3))
    a.tail should be (List(2,3))
    b.tail should be (List(3))
    c.tail should be (Nil)
  }
}