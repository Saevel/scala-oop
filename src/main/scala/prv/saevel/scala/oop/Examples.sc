import scala.util.Random

val x: Int = 10

def square(i: Int) = {
  val k = i
  k * k
}

square(10)

class Person(val name: String, val surname: String, age: Option[Int] = None)

new Person("Kamil", "Owczarek", Some(28))
new Person("Kamil", "Owczarek")

abstract class PersonOfAge {

  var age: Int
}

class FullPerson(override var age: Int) extends PersonOfAge

trait Age {

  var age: Int

}


trait PrimaryKey[T] {
  var key: T
}

trait Logger;

trait BasicLogger {
  val logger: Logger = ???
}

class PersonModel private(override var key: Int,
                  override val name: String,
                  override val surname: String,
                  val age: Option[Int] = None)
  extends Person(name, surname, age) with PrimaryKey[Int]

object PersonModel {

  def apply(name: String, surname: String, age: Option[Int] = None): PersonModel = {
    val newKey = Random.nextInt()
    new PersonModel(newKey, name, surname, age)
  }
}

case class PersonX(name: String, surname: String, age: Int)

val personX = PersonX("Kamil", "Owczarek", 12).toString


List(1, 2, 3, 4)


// --------------- //

/*
def printPersonX(x: PersonX) = println(x)

val model = PersonModel("Kamil", "Owczarek", Some(28))

implicit def personModelToPersonX(model: PersonModel): PersonX = {
  PersonX(model.name, model.surname, model.age.getOrElse(0))
}

printPersonX(model)
*/

val intList = List(1,2,3,4)

val doubleList = List(1.0, 5.0, 7.0)

trait Adder[X] {

  def add(a: X, b: X): X

  def zero: X
}

def sum[X](l: List[X])(implicit adder: Adder[X]): X =
  l.fold(adder.zero)((x, y) => adder.add(x, y))

implicit val intAdder = new Adder[Int]{
  override def add(a: Int, b: Int) = a + b

  override def zero = 0
}

implicit val doubleAdder = new Adder[Double] {
  override def add(a: Double, b: Double) = a + b

  override def zero = 0.0
}

sum(intList)

sum(doubleList)

val numeric: Numeric[Int] = ???

implicit class Square[T](i: T)(implicit numeric: Numeric[T]){
  def cube: T = numeric.times(i, numeric.times(i, i))
}

3.cube

2.5.cube

trait JsonProtocol[T]{
  def toJson(t:T): String
  def fromJson(s: String): T
}

implicit class Jsonizable[T](t: T)(implicit protocol: JsonProtocol[T]){

}