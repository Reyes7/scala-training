package Implicits

object HourlyRate {
  def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
    dollarsPerHour * hours

  def howMuchCanIMakeWithCurrency_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
    (amount * hours).toString() + " " + currencyName

  def howMuchCanIMakeWithDefaultParams_?(hours: Int, amountDefault: BigDecimal = 34, currencyNameDefault: String = "Dollars") =
    (amountDefault * hours).toString() + " " + currencyNameDefault

  implicit val currencyName = "Dollars"

  implicit val hourlyRate = BigDecimal(30)
}
