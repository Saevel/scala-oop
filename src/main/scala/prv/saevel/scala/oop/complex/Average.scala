package prv.saevel.scala.oop.complex

object Average {

  def apply[T](data: List[T])(implicit addition: Addition[T], division: DivisionByInt[T]): T = if(data.isEmpty)addition.zero else division.divideBy(data.fold(addition.zero)(addition.add), data.length)
}