package classes

import org.scalatest._

class ClassWithValParameterTest extends FunSuite with Matchers{ // https://www.scala-exercises.org/std_lib/classes

  test("can I create field in class from given parameter ?"){
    val exampleObj = new ClassWithValParameter("Reyes")
    exampleObj.name should be ("Reyes")
  }
}
