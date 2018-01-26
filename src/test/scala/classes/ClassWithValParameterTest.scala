package classes

import org.scalatest._

/**

      * https://www.scala-exercises.org/std_lib/classes

*/

class ClassWithValParameterTest extends FunSuite with Matchers{

  test("can I create field in class from given parameter ?"){
    val exampleObj = new ClassWithValParameter("Reyes")
    exampleObj.name should be ("Reyes")
  }
}
