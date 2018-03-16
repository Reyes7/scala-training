package parentClasses

class Pilot(
             override val firstName: String,
             override val lastName: String,
             val squadron: Long
           ) extends Soldier(firstName, lastName) {

}