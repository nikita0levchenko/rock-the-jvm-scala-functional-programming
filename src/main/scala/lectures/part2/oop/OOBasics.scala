package lectures.part2.oop

object OOBasics extends App {
  val person: Person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()
  val person1 = new Person("Nick")
  person1.greet()
  val aCountValue: Counter = new Counter(10)
  println(aCountValue.increment(5).value)
  println(aCountValue.decrement(5).value)
}

//constructor
class Person(name: String, val age: Int) {
//body
  val x = 2
  println(1 + 2)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, $name") // equals ${this.name}

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  //Problem of multiple constructors can be solved by default parameters
}
// class parameters are NOT FIELDS

/*
1) Implement a novel and writer class
WRITER CLASS DESCRIPTION
Writer's fields:  first name, surname, year of birth
Writer's methods:
-fullname: String = first name + surname

NOVEL CLASS DESCRIPTION
Novel's fields: name, year of release, author: Writer
Novel's methods:
-authorAge: String = age of author + name of release
-writenBy: Writer = author
-copy(new year of release): Novel = new Novel
 */

class Writer(val firstName: String, val surname: String, val yearOfBirth: Int){
  def fullName(): String = s"$firstName $surname"
}

class Novel(val name: String, val yearOfRelease: Int, author: Writer){
  def authorsAge(): Int = yearOfRelease - author.yearOfBirth
  def writtenBy(author: Writer): Boolean = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
}

/*
Counter class, which receives
-receive an Int
-has a method which return a current count
-method to increment
-method to decrement
 */

class Counter(val value: Int){
  def increment: Counter = { //immutability
    println("incrementing")
    new Counter(value + 1)
  }

  def increment(amount: Int, acc:Counter = this): Counter = amount match {
    case 0 => acc
    case _ => increment(amount - 1, acc.increment)
  }

  def decrement: Counter = {
    println("decrementing")
    new Counter(value - 1)
  }

  def decrement(amount: Int, acc: Counter = this): Counter = amount match {
    case 0 => acc
    case _ => decrement(amount - 1, acc.decrement)
  }
}