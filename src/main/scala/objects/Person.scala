package objects

class Person(val name: String, private val superheroName: String)

object Person {
  def showMeInnerSecret(x: Person) = x.superheroName
}