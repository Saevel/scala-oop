package prv.saevel.scala.oop.cars
import scala.util.Random
import prv.saevel.scala.oop.persistence.PrimaryKey

class Car protected(
  private val serialNumber:Long,
  val brand:String,
  val model:String,
  var owner:String
)extends PrimaryKey[Long] {
  override val id: Long = serialNumber
}

object Car {
  def apply(brand: String, model: String, owner: String): Car = new Car(Random.nextLong(),brand,model,owner)
}