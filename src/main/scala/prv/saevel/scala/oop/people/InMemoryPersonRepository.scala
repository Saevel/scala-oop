package prv.saevel.scala.oop.people

import prv.saevel.scala.oop.persistence.InMemoryRepository

object InMemoryPersonRepository extends PersonRepository with InMemoryRepository[Long, Person]
