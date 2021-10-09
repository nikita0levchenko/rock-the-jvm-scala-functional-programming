package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  //vals are immutable

  val aString: String = "hello"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 5554
  val aLong: Long = 2519235925627L
  val aFloat: Float = 1.0f
  val aDouble: Double = 3.14

  //variables
  var aVariable: Int = 4
  aVariable = 5 //side effects
}
