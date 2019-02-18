package prv.saevel.scala.oop

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import prv.saevel.scala.oop.complex.ComplexNumber

trait ComplexNumberGenerator {

  val complexNumbers: Gen[ComplexNumber] = for {
    real <- arbitrary[Double]
    imaginary <- arbitrary[Double]
  } yield new ComplexNumber(real, imaginary)
}
