package prv.saevel.scala.oop

package object complex {

  implicit class ComplexModulus(c: ComplexNumber){
    def modulus: Double = Math.sqrt(c.real * c.real + c.imaginary * c.imaginary)
  }
}
