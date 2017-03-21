package objects

import org.scalatest.{FunSuite, Matchers}

class PersonTest extends FunSuite with Matchers{

  test("is Clark Kent a superman ?"){
    val clark = new Person("Clark Kent", "Superman")
    Person.showMeInnerSecret(clark) should be("Superman")
  }

  test("is Bruce Wayne a batman ?"){
    val bruce = new Person("Bruce Wayne", "Batman")
    Person.showMeInnerSecret(bruce) should be("Batman")
  }
}
