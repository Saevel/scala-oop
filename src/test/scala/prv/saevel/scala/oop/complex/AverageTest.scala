package prv.saevel.scala.oop.complex

import org.junit.runner.RunWith
import org.scalacheck.Gen
import org.scalacheck.Arbitrary._
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class AverageTest extends WordSpec with Matchers with PropertyChecks {

  implicit def additionGenerator[T](implicit numeric: Numeric[T]): Addition[T] = new Addition[T] {
    override def zero: T = numeric.zero
    override def add(x: T, y: T): T = numeric.plus(x, y)
  }

  implicit val doubleByInt = new DivisionByInt[Double] {
    override def divideBy(t: Double, i: Int): Double = t / i.toDouble
  }

  implicit val floatByInt = new DivisionByInt[Float]{
    override def divideBy(t: Float, i: Int): Float = t / i.toFloat
  }

  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.01)

  implicit def complexEquality(implicit doubleEquality: Equality[Double]): Equality[ComplexNumber] = new Equality[ComplexNumber]{
    override def areEqual(a: ComplexNumber, b: Any): Boolean = b match {
      case c: ComplexNumber => doubleEquality.areEqual(a.real, c.real) && doubleEquality.areEqual(a.imaginary, c.imaginary)
      case _ => false
    }
  }

  private val listsOfDoubles = Gen.listOf(arbitrary[Double])

  private val complexNumbers: Gen[ComplexNumber] = for {
    real <- arbitrary[Double]
    imaginary <- arbitrary[Double]
  } yield new ComplexNumber(real, imaginary)

  private val listsOfComplexNumbers = Gen.listOf(complexNumbers)

  private val listsOfFloats = Gen.listOf(arbitrary[Float])

  "Can calculate a Double average" in forAll(listsOfDoubles){ list =>
    Average(list) should equal(doubleAverage(list))
  }

  "Can calculate a Float average" in forAll(listsOfFloats){ list =>
    Average(list) should equal(floatAverage(list))
  }

  "Can calculate a Complex average" in forAll(listsOfComplexNumbers){ list =>
     Average(list) should equal(complexAverage(list))
  }

  private def complexZero = new ComplexNumber(0.0, 0.0)

  private def ++(x: ComplexNumber, y: ComplexNumber): ComplexNumber = new ComplexNumber(x.real + y. real, x.imaginary + y.imaginary)

  private def doubleAverage(list: List[Double]) = if(list.isEmpty) 0.0 else (list.fold(0.0)(_+_) / list.size)

  private def floatAverage(list: List[Float]) = if(list.isEmpty) 0f else (list.fold(0f)(_+_) / list.size)

  private implicit class ComplexDivision(c: ComplexNumber){
    def /(i: Int): ComplexNumber = new ComplexNumber(c.real / i, c.imaginary / i)
  }

  private def complexAverage(list: List[ComplexNumber]) =
    if(list.isEmpty) complexZero else list.fold(complexZero)(++) / list.size
}
