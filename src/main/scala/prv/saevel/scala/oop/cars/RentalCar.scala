package prv.saevel.scala.oop.cars

class RentalCar(serialNumber:Long, override val brand:String, override val model:String, owner:String, val rental:String) extends Car(serialNumber,brand,model,owner)
