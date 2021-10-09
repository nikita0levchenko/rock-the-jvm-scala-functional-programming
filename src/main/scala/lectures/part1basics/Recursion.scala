package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n: Int): Int = if(n == 1) 1 else {
    println(s"Computing factorial of $n, but first I need figure out factorial of ${n - 1}")
    val result = n * factorial(n - 1)
    println(s"Computed of factorial $n is done")
    result
  }
  println(factorial(5))
  //LEADS TO STACK OVERFLOW ERROR

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def auxiliaryFunc(n: Int, acc: BigInt): BigInt = if(n == 1) 1 else auxiliaryFunc(n - 1, acc * n)
    auxiliaryFunc(n, 1)
  }
  //TAIL RECURSION = [use the recursive call as the last expression]
  //auxiliaryFunc - is tail recursive
  //WHEN YOU NEED LOOPS USE THE TAIL RECURSION

  /*
  EXERCISES
  1) Concatenate string n times (String, Int) => String
   */

  def concatTailString(str: String, n: Int): String = {
    @tailrec
    def loop(it: Int, acc: String = ""): String = it match {
      case 0 => acc
      case _ => loop(it - 1, s"$str $acc")
    }
    loop(n)
  }
  println(concatTailString("I'll be the best programmer", 5))

  /*
  2) Prime function with tail recursion
   */

  def isPrime: Int => Boolean = digit => {
    @tailrec
    def loop(it: Int = digit / 2): Boolean = it match {
      case 1 => true
      case i if(digit % i == 0) => false
      case _ => loop(it - 1)
    }
    loop()
  }
  println(isPrime(2003))
  println(isPrime(629))

  /*
  3) Fibonacci function with tail recursive
   */

 def fibonacci: Int => Int = n => {
   @tailrec
   def loop(it: Int = 1, last: Int = 1, nextToLast: Int = 1): Int = it match {
     case i if(i == n - 1) => last
     case _ => loop(it + 1, last + nextToLast, last)
   }
   loop()
 }
  println(fibonacci(12))




}
