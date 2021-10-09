package lectures.part3fp

object MapFlatMapFilterFor extends App {

  val list: List[Int] = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 2))
  println(list.map(_.toString + "s"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair: Int => List[Int] = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  /*
  Exercise List(1, 2, 3, 4) X List(a, b, c, d) => List(1a, 1b, ...)
   */
  val charList: List[Char] = List('a', 'b', 'c', 'd')
  val colors: List[String] = List("#322", "#1488")

  // iterating through collection
  println(list.filter(_ % 2 == 0).flatMap(x => charList.flatMap(y => colors.map(z => s"$x$y$z"))))

  // for-comprehension way
  val decarted: List[String] = for{
    digit <- list
    char <- charList
    color <- colors
  } yield s"$digit$char$color"

  // foreach - like map, but receives a function which returns a unit
  list.foreach(println)
  println(decarted)

  // for-comprehension
  val anotherFor: List[String] = for {
    digit <- list if digit % 2 == 0
    color <- colors
    char <- charList
  } yield s"$digit$char$color"

  anotherFor.foreach(println)

  for{
    n <- list
  } println(n)

  // syntax overload
  list.map { x =>
    x * 3
  }

  /*
  Exercises
  1) MyList supports for comprehensions?
  2) A small collection of at most ONE element - Maybe[+T]
   */

}
