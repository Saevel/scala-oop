package prv.saevel.scala.oop.complex

class ComplexNumber(val real: Double, val imaginary: Double)

object ComplexNumber {

  implicit val addition: Addition[ComplexNumber] = ???

  implicit val division: DivisionByInt[ComplexNumber] = ???
}