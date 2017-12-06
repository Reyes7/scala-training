package classes

case class Employee (
                      firstName : String,
                      lastName: String,
                      age : Int = 0,
                      position: String = "",
                      phone: String = ""
                    )