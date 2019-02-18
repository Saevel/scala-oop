package prv.saevel.scala.oop.cars

import prv.saevel.scala.oop.people.{Person, PersonRepository}

class RentalService(implicit carRepository: CarRepository, personRepository: PersonRepository) {

  def rentalPossible(carId: Long, personId: Long): Boolean = {
    val carOption = carRepository.findById(carId)
    val personOption = personRepository.findById(personId)
    carOption.isDefined && personOption.isDefined
  }

  def addPerson(person: Person): Option[Person] = personRepository.save(person)

  def allPeople: List[Person] = personRepository.findAll

  def addCar(car: Car): Option[Car] = carRepository.save(car)

  def allCars: List[Car] = carRepository.findAll
}
