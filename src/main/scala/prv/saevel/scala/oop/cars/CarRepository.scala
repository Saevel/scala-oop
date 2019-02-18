package prv.saevel.scala.oop.cars

import prv.saevel.scala.oop.persistence.Repository

trait CarRepository extends Repository[Long, Car]
