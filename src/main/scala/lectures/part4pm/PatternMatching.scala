package lectures.part4pm

import java.beans.Expression
import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if (a < 21) => s"Hi my name is $n and I can't drink in US"
    case Person(n, a) => s"Hi my name is $n and my age is $a years old"
    case _ => "I don't know who I'm"
  }
  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match => scala.MatchError
  3. what the type of PM expression? unified type of all the types in all the cases
  4. PM works really well with case classes
   */

  // PM on sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Martin")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed")
    case Parrot(someGreeting) => println(s"Matched a parrot of the $someGreeting greed")
  }

  /*
  In PM on sealed classes u will get a warning about match may not be exhaustive.
  It will cover your ass from scala.MatchError
   */

  /*
  Exercise
  simple function uses PM takes an Expr => human readable form
   */

  trait Expression

  case class Number(n: Int) extends Expression

  case class Sum(e1: Expression, e2: Expression) extends Expression

  case class Prod(e1: Expression, e2: Expression) extends Expression

  def mathConverter(expr: Expression): String = expr match {
    case Number(n: Int)                        => s"$n"
    case Sum(e1, e2)                           => s"${mathConverter(e1)} + ${mathConverter(e2)}"
    case Prod(e1: Sum, e2: Sum)                => s"(${mathConverter(e1)}) * (${mathConverter(e2)})"
    case Prod(e1:Number, e2: Sum)              => s"${mathConverter(e1)} * ${mathConverter(e2)}"
    case Prod(e1: Sum, e2: Expression)         => s"(${mathConverter(e1)}) * ${mathConverter(e2)}"
    case Prod(e1: Expression, e2: Expression)  => s"${mathConverter(e1)} * ${mathConverter(e2)}"

  }

  val x1: Number = Number(3)
  val x2: Number = Number(2)
  val simpleSum: Sum = Sum(x1, x2)
  val simpleProd: Prod = Prod(x1, x2)
  val sumOnProd: Sum = Sum(x2, simpleProd)
  val prodOnSum: Prod = Prod(x1, simpleSum)
  val prodOfTwoSums: Prod = Prod(simpleSum, simpleSum)
  val sumOfTwoProds: Sum = Sum(simpleProd, simpleProd)
  val hardSum: Sum = Sum(prodOfTwoSums, sumOfTwoProds)
  println(mathConverter(x1))
  println(mathConverter(simpleSum))
  println(mathConverter(simpleProd))
  println(mathConverter(sumOnProd))
  println(mathConverter(prodOnSum))
  println(mathConverter(prodOfTwoSums))
  println(mathConverter(sumOfTwoProds))
  println(mathConverter(hardSum))
}
