package traits

class MyListener extends EventListener{

  def listen(event: Event): String = {
    event match {
      case Event("Simple Event") => "This is a simple event"
      case _ => "Nothing of importance occurred"
    }
  }
}
