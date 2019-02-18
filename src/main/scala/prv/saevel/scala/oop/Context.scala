package prv.saevel.scala.oop

import prv.saevel.scala.oop.cars.{CarRepository, InMemoryCarRepository, RentalService}
import prv.saevel.scala.oop.people.InMemoryPersonRepository

object Context {

  implicit val carRepository = InMemoryCarRepository

  implicit val personRepository = InMemoryPersonRepository

  implicit val rentalService = new RentalService
}
