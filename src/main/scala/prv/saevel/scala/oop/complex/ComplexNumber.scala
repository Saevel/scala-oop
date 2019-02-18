package prv.saevel.scala.oop.complex

class ComplexNumber(val real: Double, val imaginary: Double)

object ComplexNumber {

  implicit val addition = new Addition[ComplexNumber] {

    override def zero: ComplexNumber = new ComplexNumber(0.0, 0.0)

    override def add(x: ComplexNumber, y: ComplexNumber): ComplexNumber = new ComplexNumber(x.real + y.real, x.imaginary + y.imaginary)
  }

  implicit val division = new DivisionByInt[ComplexNumber] {
    override def divideBy(t: ComplexNumber, i: Int): ComplexNumber = new ComplexNumber(t.real / i.toDouble, t.imaginary / i.toDouble)
  }
}