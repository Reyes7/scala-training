package byNameParameters

object ByNameParameter {
  def calc(x: () => Int): Either[Throwable, Int] = {
    try {
      Right(x()) //An explicit call of the x function
    } catch {
      case b: Throwable => Left(b)
    }
  }

  def anotherCalc(x: => Int): Either[Throwable, Int] = {
    //x is a call by name parameter
    try {
      Right(x)
    } catch {
      case b: Throwable => Left(b)
    }
  }

  def apply(x: => String) = x.tail + x.head + "ay"
}
