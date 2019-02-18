package prv.saevel.scala.oop.persistence

trait Repository[ID, T <: PrimaryKey[ID]] {

  def save(t: T): Option[T]

  def findAll: List[T]

  def findById(id: ID): Option[T]
}
