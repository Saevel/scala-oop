package prv.saevel.scala.oop.cars

import prv.saevel.scala.oop.persistence.PrimaryKey

class Car extends PrimaryKey[Long] {
  override val id: Long = ???
}

object Car {
  def apply(brand: String, model: String, owner: String): Car = ???
}