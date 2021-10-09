package lectures.part1basics

object StringOps extends App{

  val aString = "Hello, I am learning Scala"

  println(aString.charAt(2))
  println(aString.substring(7,11))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ", "-"))
  println(aString.toLowerCase())
  println(aString.toUpperCase())
  println(aString.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)
  println('a' +: aNumberString :+ 'z')
  println(aString.reverse)
  println(aString.take(2))
  println(aString.takeRight(2))

  //Scala specific thing interpolators

  //S - interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I'm a $age years old"
  val anotherGreeting = s"Hello, my name is $name and I'm a ${age + 1} years old"
  println(anotherGreeting)

  //F - interpolators
  val speed = 2.3f
  val myth = f"$name%s can eat $speed%2.3f burgers per minute"
  println(myth)

  val x: Float = 1.1f
  val str: String = f"$x%3f"

  //raw - inetrpolators
  println(raw"This is \n new line")
  val escaped = "This is a \n new line"
  println(raw"$escaped")
}
