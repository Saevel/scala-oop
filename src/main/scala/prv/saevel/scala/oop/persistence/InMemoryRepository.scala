package prv.saevel.scala.oop.persistence

trait InMemoryRepository[ID, T <: PrimaryKey[ID]] extends Repository[ID, T] {

  protected var items: List[T] = List.empty

  override def save(t: T): Option[T] = if (items.exists(t => t.id == t.id)) {
    None
  } else {
    items = items :+ t
    Some(t)
  }

  override def findAll: List[T] = items

  override def findById(id: ID): Option[T] = items.find(t => t.id == id)
}
