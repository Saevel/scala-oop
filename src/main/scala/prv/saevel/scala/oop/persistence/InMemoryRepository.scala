package prv.saevel.scala.oop.persistence

trait InMemoryRepository[ID, T <: PrimaryKey[ID]] extends Repository[ID, T] {

  protected var items: List[T] = List.empty

  override def save(t: T): Option[T] = if (items.exists(t => t.id == t.id)) {
    println("nieudane dodanie")
    println(t)
    println(t.id)
    println(items)
    None
  } else {
    items = items :+ t
    println("udane dodanie")
    println(t)
    println(t.id)
    println(items)
    Some(t)
  }

  override def findAll: List[T] = items

  override def findById(id: ID): Option[T] = items.find(t => t.id == id)
}
