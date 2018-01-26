package Implicits

import java.math.BigInteger

object MySum {

  implicit def Int2BigIntegerConvert(value: Int): BigInteger =
    new BigInteger(value.toString)

  def add(a: BigInteger, b: BigInteger) = a.add(b)
}
