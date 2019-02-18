Welcome to the second part of the Scala training - OOP in Scala

1. In the "prv.saevel.scala.oop.cars" package create the Car class with the following:

    * a private, immutable field "serialNumber", of type Long
    
    * a public, immutable field "brand", of type String
    
    * a public, immutable field "model", of type String
    
    * a public, mutable field "owner", of type String
    
    * one, protected constructor
    
    * extending PrimaryKey[Long] and defining its "id" as equal to "serialNumber"
    
    * a companion object with an apply method that takes the brand, model and owner of a Car and sets the "serialNumber"
    to the value obtained by randomization from Random.nextLong()
    
2.  In "prv.saevel.scala.oop.people" package create the Person class with the following:

    * a public, immutable field "id", of type Long
    
    * a public, immutable field name, of type String
    
    * one, private constructor
    
    * extending PrimaryKey[Long] and defining it's "id" as equal to the basic "id" defined above 
        
    * a companion object with an apply method that takes the name and surname of a Person and sets the "id"
          to the value obtained by randomization from Random.nextLong()

3. In "prv.saevel.scala.oop.cars" define a class called RentalCar with the following:

    * extending Car and overriding all mandatory fields
    
    * adding a public, immutable field "rental", of type String  
    
              
4. In the "prv.saevel.scala.oop.cars" package, complete the CarRepository trait by adding the following abstract methods:
 
    * "findByBrand" that takes a String and returns a List of Cars
    
    * "findByModel" that takes a String and returns a List of Cars
    
5. Uncomment the implementation in the InMemoryCarRepository and InMemoryPersonRepository

6. Modify the Context class so that InMemory implementations are assigned to proper repositories

7. Uncomment the "printPerson" and "printCar" methods in the "Application" class and run the program to verify it works correctly


=======

8. Implement the "apply" method in the "Average" class so that it calculates the Average for any type with 
"Addition" and "DivisionByInt" typeclasses defined

9. Implement the "addition" and "division" typeclass instances in the "ComplexNumber" companion object according to complex
number algebra

10. Run the "AverageTest" to verify the correctness of your implementation
    
11. Write an implicit class to add a method called "modulus" onto the ComplexNumber that would calculate its modulus
according to the formula:

    modulus(z) = square_root[Re(z) * Re(z) + Im(z) * Im(z)]
    
12. Uncomment and run the contents of the ModulusTest to verify the correctness of your implementation               