package prv.saevel.scala.oop.people

import prv.saevel.scala.oop.persistence.PrimaryKey

import scala.util.Random

class Person extends PrimaryKey[Long] {
  override val id: Long = ???
}

object Person {
  def apply(name: String, surname: String): Person = ???
}
