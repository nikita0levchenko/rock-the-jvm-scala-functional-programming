package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use and work with functions as first class elements
  // PROBLEM: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B] , Function2
  val stringToIntConverter: String => Int = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("4") + 4)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(adder(3, 7))

  // Function types Function2[A,B,C] === (A, B) => C

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1) Define a function which take two strings and concatenates them
  2) Go to MyList and transform MyTransformer and MyPredicate into a function types
  3) define a function which take an int argument, and return another function which takes an int and return an int
      - define type of this function
      - how to do it
   */

  //1)
  val concat: (String, String) => String = (s1, s2) => s1 + s2

  //2)
  // see MyList, EmptyList, ListImp, ScalaPlayground

  //3)
  //def sum: Int => Int => Int = s1 => s2 => s1 + s2
  def sum: Int => Int => Int = s1 => _ + s1
  val curriedSum: Int => Int = sum(2)
  println(curriedSum)
  println(curriedSum(5))
  println(sum(4)(11)) // curried function

  //map, flatMap, filter - higher order functions
}

trait MyFunction[A, B]{
  def apply(element: A): B
}
