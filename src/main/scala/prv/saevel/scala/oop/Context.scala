package prv.saevel.scala.oop

import prv.saevel.scala.oop.cars.{Car, CarRepository, InMemoryCarRepository, RentalService}
import prv.saevel.scala.oop.people.{InMemoryPersonRepository, Person, PersonRepository}
import prv.saevel.scala.oop.persistence.Repository

object Context {

  implicit val carRepository: CarRepository = InMemoryCarRepository

  implicit val personRepository: PersonRepository = InMemoryPersonRepository

  implicit val rentalService = new RentalService
}
