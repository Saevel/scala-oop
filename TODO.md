Welcome to the second part of the Scala training - OOP in Scala

1. In the "prv.saevel.scala.oop.cars" package create the Car class with the following:

    // class Car protected (private val serialNumber: Long, val brand: String, val model: String, var owner: String) extends PrimaryKey[Long] {
         override val id: Long = serialNumber
       }

    * has a private, immutable field "serialNumber", of type Long
    
    * has a public, immutable field "brand", of type String
    
    * has a public, immutable field "model", of type String
    
    * has a public, mutable field "owner", of type String
    
    * has only one, protected consutrctor
    
    * extends PrimaryKey[Long] and defines its "id" as equal to "serialNumber"
    
    * has companion object with an apply method that takes the brand, model and owner of a Car and sets the "serialNumber"
    to the value obtained by randomization from Random.nextLong()
    
2.     