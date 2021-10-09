package lectures.part2.oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} hang out with ${person.name}"
    def +(nickname: String): Person =
      new Person(s"${this.name}($nickname)", this.favoriteMovie, this.age)
    def unary_! : String = s"$name kind a sus"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name, and I like $favoriteMovie"
    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = this learns "Scala"

  }

  val mary = new Person("Mary", "SomeMovie", 24)
  println(mary.likes("SomeMovie"))
  println(mary likes "SomeMovie") //equivalent
  //infix notation == operator notation (syntactic sugar)

  //operators in scala
  val tom = new Person("Tom", "Fight club", 24)
  println(mary + tom)

  println(1.+(2))
  //ALL OPERATORS ARE METHODS
  //Akka actors have a methods ! and ?

  //prefix notations
  val x = -1 // minus is the unary operator
  val y = 1.unary_- //the same as expression above
  // unary prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // mary() == mary.apply()


  /*
  EXERCISES
  1) Overload + operator in Person class, which return a new Person with name(nickname)
  mary + "rockstar" => new Person("Mary(rockstar), ...)
   */
  println((mary + "rockstar")())

  /*
  2) Add a age parameter into Person class
     Add a unary + operator which increment person's age
     +mary => mary with the age incremented
   */
  println((+mary).age)
  /*
  3) Add a "learns" method in the Person class => "Mary learns something"
     Add a learnsScala method calls learns method with Scala => "Mary learns Scala"
     Use it in postfix notation
   */
  println(mary learns "something") //infix
  println(mary learnsScala)        //postfix

  /*
  4) Overload the apply method which receive the integer, and return the next string
  mary.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))
}
