package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App{

  def aFunction(aString: String, aInt: Int): String = s"$aString $aInt"
  println(aFunction("hello",3))

  def aParameterlessFunction: Int = 42
  println(aParameterlessFunction)

  def multipleString(str: String, times: Int): String = times match {
    case 1 => str
    case _ => s"$str ${multipleString(str, times - 1)}"
  }
  println(multipleString("Hi", 5))
  //USE ONLY RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(a: String): String = {
    def aSmallerFunction(b: String, c: String): String = s"$b $c"
    s"${aSmallerFunction(a, s"sus with $a")} $a"
  }

  /*PRACTICE WITH FUNCTIONS
  1) A greeting function for the kids (name, age) => "Hi my name is $name, and I'm a $age years old"
  */
  def aKidFunc: (String, Int) => String = (name, age) => s"Hi my name is $name, and I'm a $age years old"
  println(aKidFunc("Christopher", 10))

  /*
  2) A factorial function factorial(5) => 120
  */
  def aFactorial: (Int, Int) => Int = (n, acc) => n match {
    case 1 => acc
    case _ => aFactorial(n - 1, n * acc)
  }
  println(aFactorial(5,1))

  /*
  3) A Fibonacci function (7) => 8
   */

  def aFibonacci:Int => Int = {
    case 1 => 1
    case 2 => 1
    case n => aFibonacci(n - 1) + aFibonacci(n - 2)
  }
  println(aFibonacci(8))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeCheck(it: Int = n - 1): Boolean = it match {
      case 1 => true
      case it if(n.toDouble % it.toDouble == 0.0) => false
      case _ => primeCheck(it - 1)
    }
    primeCheck()
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
