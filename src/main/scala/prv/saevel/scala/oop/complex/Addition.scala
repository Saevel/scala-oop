package prv.saevel.scala.oop.complex

trait Addition[T] {

  def zero: T

  def add(x: T, y: T) : T
}
