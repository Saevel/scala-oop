package prv.saevel.scala.oop.cars

class RentalCar(override val id:Long,
                override val brand:String,
                override val model:String,
                owner:String,
                var rental:Long)
  extends Car(id,brand,model,owner)