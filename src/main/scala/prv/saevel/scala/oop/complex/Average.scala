package prv.saevel.scala.oop.complex

object Average {

  def apply[T](data: List[T])(implicit addition: Addition[T], division: DivisionByInt[T]): T = {
    if(data.isEmpty) {
      addition.zero
    } else {
      var sum: T = addition.zero
      for(item <- data){
        sum = addition.add(sum, item)
      }
      division.divideBy(sum, data.size)
    }
  }
}