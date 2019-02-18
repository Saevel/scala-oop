package prv.saevel.scala.oop.complex

object Average {

  def apply[T](data: List[T])(implicit addition: Addition[T], division: DivisionByInt[T]): T = ???
}