package classes

import org.scalatest._

class ClassWithValParameterTest extends FunSuite with Matchers{ // https://www.scala-exercises.org/std_lib/classes

  test("is class name from given parameter ?"){
    val exampleObj = new ClassWithValParameter("Reyes")
    exampleObj.name should be ("Reyes")
  }
}
