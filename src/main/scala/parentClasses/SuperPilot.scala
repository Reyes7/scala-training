package parentClasses

class SuperPilot(override val firstName: String, override val lastName: String, val squadron: Long)
  extends SuperSoldier(firstName, lastName)
