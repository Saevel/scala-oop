package prv.saevel.scala.oop.people

import prv.saevel.scala.oop.persistence.Repository

trait PersonRepository extends Repository[Long, Person]
