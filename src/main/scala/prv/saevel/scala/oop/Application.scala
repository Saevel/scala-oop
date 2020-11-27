package prv.saevel.scala.oop

import java.util.Scanner
import prv.saevel.scala.oop.cars.Car
import prv.saevel.scala.oop.people.Person


object Application {
  import prv.saevel.scala.oop.Context._

  def main(args: Array[String]): Unit = {

    println("What do you want to do: \n A. Add a person \n B. List all people \n C. Add a car \n D. List all cars " +
      "\n E. Check a rental/Rent a car \n F. Return car \n Other char: Exit")

    val input = new Scanner(System.in).next.toUpperCase.toString
    println(input)
    if(input == "A"){
      readAndSavePerson
      main(args)
    }
    else if(input == "B"){
      printAllPeople()
      main(args)
    }
    else if(input == "C"){
      readAndSaveCar
      main(args)
    }
    else if(input == "D"){
      printAllCars()
      main(args)
    }
    else if(input == "E"){
      readAndCheckRental
      main(args)
    }
    else if(input == "F"){
      returnCar
      main(args)
    }
    else {}
  }

  private def returnCar = {
    if (!printAllOccupiedCars) {
      println("Which car do you want to return? Please enter car number: ")
      val carId = new Scanner(System.in).nextLong()
      var l = 0
      for (car <- rentalService.allCars) {
        if (l == carId) {
          car.isFree = true
          car.owner = ""
          println("You successfuly returned: ")
          printCar(car)
        }
        l += 1
      }
    }
  }

  private def readAndCheckRental = {
    printAllPeople(true)
    println("Specify number: ")
    var z = 0
    var selectedPersonId:Long = 0
    val personSelector:Int = new Scanner(System.in).nextInt()
    for (person<-rentalService.allPeople){
      if (z == personSelector){
        selectedPersonId = person.id
      }
      z+=1
    }
    printAllCars(true)
    println("Specify number: ")
    var k = 0
    var selectedCarId:Long = 0
    val carSelector = new Scanner(System.in).nextInt()
    for (car<-rentalService.allCars){
      if (k==carSelector){
        selectedCarId = car.id
      }
      k+=1
    }
    if (rentalService.rentalPossible(selectedCarId, selectedPersonId)) {
      println("Rental possible.")
      print("Do you want to rent ")
      for (car<-rentalService.allCars){
        if (selectedCarId==car.id && car.isFree == true){
          printCar(car)
        }
      }
      println("1 - YES")
      println("2 - NO")
      val answer = new Scanner(System.in).nextLine()
      if (answer == "1"){
        rentACar(selectedCarId,selectedPersonId)
      } else{
      }
    } else {
      println("Rental impossible")
    }
  }

  private def rentACar(carId:Long,personId:Long) = {
    for (car<-rentalService.allCars){
      if (carId==car.id && car.isFree == true){
        for (person<-rentalService.allPeople){
          if (personId == person.id){
            car.isFree = false
            car.owner = person.surname
            println(car)
            println("Lease for: "+ printCar(car)+" SUCCESSFUL")
          }
        }
      }
    }
  }

  private def printAllCars(withNumbers:Boolean = false) = {
    var i = 0
    if (withNumbers == true) {
      for (car <- rentalService.allCars) {
        print(i+") ")
        printCar(car)
        i+=1
      }
      } else{
      for (car <- rentalService.allCars) {
        printCar(car)
      }
    }
  }

  private def printAllOccupiedCars:Boolean = {
    var i = 0
    var noOccupiedCars = true
    for (car <- rentalService.allCars) {
      if (!car.isFree) {
        print(i + ") ")
        printCar(car)
        i += 1
        noOccupiedCars = false
      }
    }
    return noOccupiedCars
  }


  private def printCar(car: Car): Unit = {
    print("Car[id = " + car.id + ", model = " + car.model + ", brand = " + car.brand + ", owner = " + car.owner + ", isFree: ")
    if(car.isFree){
      println("YES]")}
      else{
      println("NO]")
  }}

  private def checkIfEmpty(input:String):Boolean = {
    if (input.length!=0){
      false
    } else{
      println("This position can't be empty.")
      true
    }
  }

  private def readAndSaveCar = {
    var empty:Boolean = true
    var brand:String = ""
    var model:String = ""
    while(empty) {
      println("Specify brand: ")
      brand = new Scanner(System.in).nextLine()
      empty = checkIfEmpty(brand)
    }
    empty = true
    while (empty) {
      println("Specify model: ")
      model = new Scanner(System.in).nextLine()
      empty = checkIfEmpty(model)
    }
    println("Specify owner: ")
    val owner = new Scanner(System.in).nextLine()
    if (rentalService.addCar(Car(brand, model, owner, true)).isDefined) {
      println("Added new car")
    } else {
      println("Failed to add car because of id clash. Try again")
    }
  }

  private def printAllPeople(withNumbers:Boolean=false) = {
    var i = 0
    if (withNumbers) {
      for (person <- rentalService.allPeople) {
        print(i + ") ")
        printPerson(person)
        i += 1
      }
    } else
      {
        for (person <- rentalService.allPeople) {
          printPerson(person)
        }
      }
  }

  private def printPerson(person: Person): Unit = {
    println("Person[id = " + person.id + ", name = " + person.name + ", surname = " + person.surname + "]")
  }

  private def readAndSavePerson = {
    var name:String = ""
    var surname:String = ""
    var empty = true
    while (empty){
      println("Specify name: ")
      name = new Scanner(System.in).nextLine()
      empty = checkIfEmpty(name)
    }
    empty = true
    while (empty){
      println("Specify surname: ")
      surname = new Scanner(System.in).nextLine()
      empty = checkIfEmpty(surname)
    }
    if (rentalService.addPerson(Person(name, surname)).isDefined) {
      println("Added new person")
    } else {
      println("Failed to add person because of id clash. Try again")
    }
  }
}