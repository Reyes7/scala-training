package asserts

import org.scalatest._

class TestExamples extends FunSuite with Matchers{ // https://www.scala-exercises.org/std_lib/asserts

  test("Is left side equals to right") {
    val left = 2
    val right = 1

    assert(left == right)
  }

   test("is 5 - 2 = 3 ?"){
     val a = 5
     val b = 3
     assertResult(2){
      a - b
    }
  }

  test("is 2 + 2 ~ 3 ?"){
    val result = 2 + 2
    result should equal(3+-1)  // can customize equality
  }

  test("is 3 + 2 ~ 3 ?"){
    val result = 3 + 2
    result should ===(3+-1)     // can customize equality and enforce type constraints
                                // more information about error
  }

  test("is 1 + 4 = 5 ?"){
    val result = 1 + 4
    result should be(5)         // cannot customize equality, so fastest to compile
  }

  test("is 4 + 5 = 9 ?"){
    val result = 4 + 5
    result shouldEqual 9        // can customize equality, no parentheses required
  }

  test("is 5 - 2 = 3 ?"){
    val result = 5 - 2
    result shouldBe 3           // cannot customize equality, so fastest to compile, no parentheses required
  }

  ignore("exampleIgnoreTest"){  // ignore test example
    assert("This test will be ignored" == "true")
  }
}
