package parentClasses

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/parent_classes

*/

class ParentClassesTest extends FunSuite with Matchers{

  test("parent class test 1"){
    val pilot = new Pilot("John", "Rambo", 256)

    pilot.firstName should be ("John")
    pilot.lastName should be ("Rambo")
  }

  test("parent class test 2"){
    val pilot = new Pilot("John", "Rambo", 256)
    val soldier: Soldier = pilot

    soldier.firstName should be ("John")
    soldier.lastName should be ("Rambo")
  }

  test("parent class test 3"){
    val superPilot = new SuperPilot("John", "Rambo", 256)
    val catchNo = new superPilot.Catch(22)

    catchNo.number should be (22)
  }
}