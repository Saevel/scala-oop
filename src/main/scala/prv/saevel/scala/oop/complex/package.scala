package prv.saevel.scala.oop

package object complex {
  implicit class ComplexModulus(c:ComplexNumber){
    def modulus = math.sqrt(math.pow(c.real,2)+math.pow(c.imaginary,2))

  }
}
