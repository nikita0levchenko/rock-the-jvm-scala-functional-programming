package lectures.part2.oop

import scala.annotation.tailrec

object Exceptions extends App {
  val x: String = null
  // println(x.length)
  // this ^^ wil crash with the null pointer exception
  // throwing and catching exceptions

    // 1) How to throw exceptions
  //val aWeirdValue: Nothing = throw new NullPointerException

  // throwable classes extends the Throwable class
  // Exceptions and Error are the major throwable subtypes

  // 2) How to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("no Int for you") else 42

  val aPotentialFail = try{
    // this code might throw
    getInt(true)
    //getInt(false)
  } catch {
    case e: RuntimeException => 55
  }finally {
    // code wll be executed no mater what
    // is optional
    // does not influence the returned type of this expression
    // use only for side effects(logging)
    println("finally")
  }

  println(aPotentialFail)

  // 3) How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //throw exception

  /*
  1) Crash your code with the OutOfMemory Error
  2) Crash with the StackOverflow Error
  3) PocketCalculator class
      -add(x, y) => x + y
      -subtract(x, y) => x - y
      -multiply(x, y) => x * y
      -divide(x, y) => x / y

   Throw OverflowException if add(x, y) exceeds Int.Max_Value
   Throw UnderFlowException if substract(x, y) exceeds Int.Min_Value
   MathCalculationException for division by zero
   */

  // 1) Crash your code with the OutOfMemory Error
  //val hugeArray: Array[Int] = Array.ofDim(Int.MaxValue)

  // 2) Crash with the StackOverflow Error
  //def factorial(n: Int): Int = if(n == 1) 1 else n * factorial(n - 1)
  //println(factorial(50000))

  // 3)

  object PocketCalculator {
    def add: (Int, Int) => Int = (x, y) =>
      if(x > 0 && y > 0 && x + y < 0) throw OverflowException("x + y > Int.MaxValue")
      else if(x < 0 && y < 0 && x + y > 0) throw UnderFlowException("x + y < Int.MinValue")
      else x + y

    def subtract: (Int, Int) => Int = (x, y) =>
      if(x < 0 && y < 0 && x - y > 0) throw UnderFlowException("x - y < Int.MinValue")
      else if(x > 0 && y < 0 && x - y < 0) throw OverflowException("x - y > Int.MaxValue")
      else (x - y)

    def multiply: (Int, Int) => Int = (x, y) =>
      if(x < 0 && y < 0 && x * y > 0) throw OverflowException("x * y > Int.MaxValue")
      else if(x > 0 && y > 0 && x * y < 0) throw OverflowException("x * y > Int.MaxValue")
      else if(x > 0 && y < 0 && x * y > 0) throw UnderFlowException("x * y < Int.MinValue")
      else if(x < 0 && y > 0 && x * y > 0) throw UnderFlowException("x * y < Int.MinValue")
      else x * y

    def division: (Int, Int) => Int = (x, y) =>
      if(y == 0) throw MatchCalculationException("division by zero") else x / y
  }

  case class OverflowException(msg: String) extends Exception

  case class UnderFlowException(msg: String) extends Exception

  case class MatchCalculationException(msg: String) extends Exception

  PocketCalculator.add(Int.MaxValue, 1)
  PocketCalculator.subtract(Int.MinValue, 1)
  PocketCalculator.multiply(Int.MaxValue, 2)
  PocketCalculator.multiply(Int.MaxValue, -2)
  PocketCalculator.multiply(Int.MinValue, 2)
  PocketCalculator.multiply(Int.MinValue, -2)
  PocketCalculator.division(2,0)

}
