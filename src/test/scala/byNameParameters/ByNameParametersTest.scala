package byNameParameters

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/byname_parameter

*/

class ByNameParametersTest extends FunSuite with Matchers{

  test("by-name parameter test 1"){
    val y = ByNameParameter.calc{ () => 14 + 15 }
    y should be (Right(29))
  }

  test("by-name parameter test 2"){
    val y = ByNameParameter.anotherCalc {
      //This looks like a natural block
      println("Here we go!") //Some superfluous call
      val z = List(1, 2, 3, 4) //Another superfluous call
      49 + 20
    }

    y should be (Right(69))
  }

  test("by-name parameter test 3"){
    val result = ByNameParameter {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }

    result should be("retzelpay")
  }
}