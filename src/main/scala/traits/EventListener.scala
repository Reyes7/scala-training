package traits

trait EventListener {
  def listen(event: Event): String
}
