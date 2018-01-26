package traits

class CustomListener extends OurListener with EventListener {
  override def listen(event: Event): String = {
    event match {
      case Event("Simple Event") =>
        "Custom listener caught Simple Event"
      case _ => "Nothing of importance occurred"
    }
  }
}
