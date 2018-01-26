package traits

import org.scalatest.{FunSuite, Matchers}

/**

      * https://www.scala-exercises.org/std_lib/traits

*/

class TraitsTests extends FunSuite with Matchers{

  test("trait simple test"){
    val event = Event("Simple Event")
    val myListener = new MyListener
    myListener.listen(event) should be ("This is a simple event")

    myListener.isInstanceOf[MyListener] should be(true)
    myListener.isInstanceOf[EventListener] should be(true)
    myListener.isInstanceOf[Any] should be(true)
    myListener.isInstanceOf[AnyRef] should be(true)
  }

  test("can class in scala extends from trait and another class together ?"){
    val event = Event("Simple Event")
    val customListener = new CustomListener
    customListener.listen(event) should be ("Custom listener caught Simple Event")
  }

  test("can traits use self-types ?"){
    //val a = new A  //***does not compile!!!***
    val obj = new A with B
    (obj.aId + obj.bId) should be (3)
  }
}