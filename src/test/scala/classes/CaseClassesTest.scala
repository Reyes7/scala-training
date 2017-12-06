package classes

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/case_classes

      * def defines a method
      * val defines a fixed value (which cannot be modified)
      * var defines a variable (which can be modified)

*/

class CaseClassesTest extends FunSuite with Matchers{

  val person1 = Person("John", "Rambo")
  val person2 = Person("Johny" , "Bravo")
  val person3 = new Person("John", "Rambo")    // the old way of creating using new

  val employee1 = Employee("Bruce", "Wayne", 25, "software developer", "111-222-333")
  val employee2 = Employee("James", "Bond")
  val employee3 = Employee(lastName = "Wayne", firstName = "Bruce", position = "software developer")

  test("case classes objects comparision test"){
    (person1 == person2) should be(false)
    (person1 == person3) should be (true)

    (person1 eq person2) should be (false)
    (person1 eq person3) should be (false)
  }

  test("case classes hashcode comparision test"){
    (person1.hashCode == person2.hashCode) should be (false)
    (person1.hashCode == person3.hashCode) should be (true)
  }

  test("do case classes contains toString() method ?"){
    person1.toString should be("Person(John,Rambo)")
  }

  test("access to variables in case classes test"){
    person1.firstName should be ("John")
    person1.lastName should be ("Rambo")
  }

  test("do case classes have mutable properties ?"){
    val dog = Dog("Scooby", "Doberman")
    dog.name should be("Scooby")
    dog.breed should be("Doberman")

    dog.name = "Scooby Dooo"
    dog.name should be ("Scooby Dooo")
  }

  test("copy case classes test"){
    val copyPerson = person1.copy(firstName = "sad")  // copy the case class but change firstName in the copy
    person1.firstName should be ("John")
    person1.lastName should be ("Rambo")

    copyPerson.firstName should be ("sad")
    copyPerson.lastName should be ("Rambo")
  }

  test("do case classes have default and named parameters ?"){
    val employee4 = employee3.copy(age = 25, phone = "111-222-333")

    employee1.firstName should be("Bruce")
    employee1.lastName should be("Wayne")
    employee1.age should be(25)
    employee1.phone should be("111-222-333")

    employee2.firstName should be("James")
    employee2.lastName should be("Bond")
    employee2.age should be (0)
    employee2.phone should be("")

    employee3.firstName should be("Bruce")
    employee3.lastName should be("Wayne")
    employee3.age should be(0)
    employee3.position should be("software developer")

    (employee1 == employee4) should be(true)
  }

  test("can case classes be disassembled to their constituent parts as a tuple ?"){
    val parts = Employee.unapply(employee1).get

    parts._1 should be("Bruce")
    parts._2 should be("Wayne")
    parts._3 should be(25)
    parts._4 should be("software developer")
    parts._5 should be("111-222-333")
  }

  test("are case classes serializable ?"){
    case class PersonCC(firstName: String, lastName: String)
    val indy = PersonCC("Indiana", "Jones")
    indy.isInstanceOf[Serializable] should be(true)

    val point = new Point(1, 2)         // no case class
    point.isInstanceOf[Serializable] should be (false)
  }
}