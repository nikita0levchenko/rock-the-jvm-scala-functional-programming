package lectures.part4pm

object PatternsEverywhere extends App {

  // big idea #1
  try{

  } catch {
    case run: RuntimeException => "runtime exception"
    case npe: NullPointerException => "null pointer exception"
    case _ => "something"
  }
  // catch - is a pattern matching

  // big idea #2
  val list = List(1,2,3,4)
  val iterated = for {
    x <- list if(x % 2 == 0)
  } yield x * 10

  // generators also a pattern matching
  val tuples = List((1,2), (3,4))
  val filterTuples = for{
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, ...

  // big idea #3
  val (a,b,c) = (1,2,3)
  println(b)
  val head :: tail = list
  println(head)
  println(tail)
  // multiple value definition base on tuples

  // big idea #4 - NEW
  // partial function based on pattern matching
  val mappedList = list map {
    case v if( v % 2 == 0) => s"$v is even"
    case 1 => "the one"
    case _ => "something else"
  }
  // code below is equals the code above
  val mappedListHint = list.map{ x => x match {
    case v if(v % 2 == 0) => s"$v is even"
    case 1 => "the one"
    case _ => "something else"
  }}

  println(mappedList)
  println(mappedListHint)
}
