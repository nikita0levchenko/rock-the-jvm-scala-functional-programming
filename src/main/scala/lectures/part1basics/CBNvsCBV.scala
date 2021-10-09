package lectures.part1basics

object CBNvsCBV extends App {

  def byValueCall(x: Long): Unit = {
    println(s"by value: $x")  //    println("123456789L")
    println(s"by value: $x")  //    println("123456789L")
  }
  println(byValueCall(System.nanoTime()))

  def byNameCall(x: Long): Unit = {
    println(s"by name: $x")   // println(System.nanoTime())
    println(s"by name: $x")   // println(System.nanoTime())
  }
  println(byNameCall(System.nanoTime()))

  def infinite(): Int = 1 + infinite() //dumb infinite function
  def printFirst(x: Int, y: => Int): Unit = println(x)
  // printFirst(infinite(), 34) - stack overflow because first parameter passed by value
  printFirst(34, infinite()) //ok, because infinite parameter passed by name and not figured out, because he doesn't need

}
