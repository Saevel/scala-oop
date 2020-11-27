package prv.saevel.scala.oop.complex

object Average {

  def apply[T](data: List[T])(implicit addition: Addition[T], division: DivisionByInt[T]): T = {
    if (data.isEmpty){
      addition.zero
    }else {
      var sum:T = addition.zero
      for (itamz <-data){
        sum = addition.add(sum,itamz)
      }
      division.divideBy(sum,data.length)
    }
  }
}