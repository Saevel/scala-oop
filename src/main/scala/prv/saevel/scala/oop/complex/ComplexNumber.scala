package prv.saevel.scala.oop.complex

class ComplexNumber(val real: Double, val imaginary: Double)

object ComplexNumber {

  implicit val addition: Addition[ComplexNumber] = new Addition[ComplexNumber] {
    override def zero: ComplexNumber = new ComplexNumber(0.0, 0.0)

    override def add(x: ComplexNumber, y: ComplexNumber): ComplexNumber = new ComplexNumber(x.real + y.real, x.imaginary + y.imaginary)
  }

  implicit val division: DivisionByInt[ComplexNumber] = new DivisionByInt[ComplexNumber] {
    override def divideBy(t: ComplexNumber, i: Int): ComplexNumber = new ComplexNumber(t.real / i, t.imaginary / i)
  }
  implicit class ComplexNumberModulos(x:ComplexNumber){
    def modulus : Double = Math.sqrt(x.real*x.real+x.imaginary*x.imaginary)
  }
}