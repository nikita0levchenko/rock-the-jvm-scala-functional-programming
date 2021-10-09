package lectures.part3fp

import scala.annotation.tailrec

object HOFsAndCurries extends App{
  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // Higher order function (HOF)
  // map, flatMap, filter

  // function that applies a function n times over value x
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = if(n == 1) f(x) else nTimes(f, n - 1, f(x))

  println(nTimes(_ * 2, 4, 4))

  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if(n == 0) (x: Int) => x else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10: Int => Int = nTimesBetter(_ + 1, 10)
  println(plus10(10))
  println(nTimesBetter(_ + 1, 10)(10))

  // curried functions
  val supperAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val plus2: Int => Int = supperAdder(2)
  println(plus2(2)) // y => 3 + y
  println(supperAdder(2)(2)) // the same as above

  // functions with multiple parameter lists
  def curriedFormatter(x: String)(c: Double): String = x.format(c)

  def defaultFormatter: Double => String = curriedFormatter("%4.2f")

    /*
    Exercises
    1) Expand MyList
       -add foreach method A => Unit
       [1, 2, 3].foreach(println) print each element
       -sort function ((A, A) => Int) => MyList[A]
       [1, 2, 3].sort((x, y) => y - x) => [3, 2, 1]
       -zipWith function (list, (A, A) => B) => MyList[B]
       [1, 2, 3].zipWith([4, 5, 6], (x, y) => x * y) => [4, 10, 18]
       -fold(startValue)(function) => value
       [1, 2, 3].fold(0)((X, y) => x + y) => 6

    2) toCurry(f: (Int, Int) => Int): Int => Int => Int
       fromCurry(f: Int => Int => Int): (Int, Int) => Int

    3) compose(f, g) => f(g(x))
       andThen(f, g) => g(f(x))
     */

  // 2) toCurry & fromCurry
  def toCurry[A](f: (A, A) => A): (A => A => A) = v1 => v2 => f(v1, v2)
  def fromCurry[A](f: (A => A => A)): (A, A) => A = (x, y) => f(x)(y)

  // 3) compose & andThen
  def compose[A,B,C](f: B => C, g: A => B): (A => C) = v1 => f(g(v1))
  def andThen[A,B,C](f: A => B, g: B => C): (A => C) = v1 => g(f(v1))

  val justAdder = fromCurry(supperAdder)
  println(justAdder(3,2))
  println(toCurry(justAdder)(3)(1))

  def mul3: Int => Int = x => x * 3
  def plu10 : Int => Int = x => x + 10
  val composed: Int => Int = compose(mul3, plu10)
  val andThenned: Int  => Int = andThen(mul3, plu10)
  println(composed(3))
  println(andThenned(3))
}
