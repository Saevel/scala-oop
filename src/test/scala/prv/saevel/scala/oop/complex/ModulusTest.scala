package prv.saevel.scala.oop.complex

import org.junit.runner.RunWith
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.PropertyChecks
import prv.saevel.scala.oop.ComplexNumberGenerator

@RunWith(classOf[JUnitRunner])
class ModulusTest extends WordSpec with Matchers with PropertyChecks with ComplexNumberGenerator {

  implicit val tolerantDoubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.01)


  "Modulus" should {

    "be implemented according to actual complex numbers algebra" in forAll(complexNumbers){ c =>
      c.modulus should equal(Math.sqrt(c.real * c.real + c.imaginary * c.imaginary))
    }
  }

}
