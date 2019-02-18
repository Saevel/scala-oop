package prv.saevel.scala.oop

import prv.saevel.scala.oop.cars.Car
import prv.saevel.scala.oop.people.Person

object Application {

  import prv.saevel.scala.oop.Context._

  def main(args: Array[String]): Unit = {

    println("What do you want to do: \n A. Add a person \n B. List all people \n C. Add a car \n D. List all cars " +
      "\n E. Check a rental \n Other char: Exit")

    val input = Console.readChar().toUpper

    if(input == 'A'){
      readAndSavePerson
      main(args)
    }
    else if(input == 'B'){
      printAllPeople
      main(args)
    }
    else if(input == 'C'){
      readAndSaveCar
      main(args)
    }
    else if(input == 'D'){
      printAllCars
      main(args)
    }
    else if(input == 'E'){
      readAndCheckRental
      main(args)
    }
    else {}
  }

  private def readAndCheckRental = {
    println("Specify person id: ")
    val personId = Console.readLong
    println("Specify car id: ")
    val carId = Console.readLong

    if (rentalService.rentalPossible(carId, personId)) {
      println("Rental possible.")
    } else {
      println("Rental impossible")
    }
  }

  private def printAllCars = {
    for (car <- rentalService.allCars) {
      printCar(car)
    }
  }

  private def printCar(car: Car): Unit =
    println("Car[id = " + car.id + ", model = " + car.model + ", brand = " + car.brand + ", owner = " + car.owner + "]")

  private def readAndSaveCar = {
    println("Specify brand: ")
    val brand = Console.readLine
    println("Specify model: ")
    val model = Console.readLine
    println("Specify owner: ")
    val owner = Console.readLine

    if (rentalService.addCar(Car(brand, model, owner)).isDefined) {
      println("Added new car")
    } else {
      println("Failed to add car because of id clash. Try again")
    }
  }

  private def printAllPeople = {
    for (person <- rentalService.allPeople) {
      printPerson(person)
    }
  }

  private def printPerson(person: Person): Unit =
    println("Person[id = " + person.id + ", name = " + person.name + ", surname =" + person.surname + "]")


  private def readAndSavePerson = {
    println("Specify name: ")
    val name = Console.readLine
    println("Specify surname: ")
    val surname = Console.readLine

    if (rentalService.addPerson(Person(name, surname)).isDefined) {
      println("Added new person")
    } else {
      println("Failed to add person because of id clash. Try again")
    }
  }
}