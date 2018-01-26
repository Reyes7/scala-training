package Implicits

abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
}