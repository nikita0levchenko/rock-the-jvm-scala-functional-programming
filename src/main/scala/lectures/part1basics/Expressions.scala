package lectures.part1basics

object Expressions extends App {

  val x: Int = 1 +  2 //Expression
  println(x)

  println(3 + 3 * 4)
  //+ - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  //== != > >= < <=

  println(!(1 == x))
  //! && ||

  var aVariable = 2
  aVariable += 3 //also works with -= *= /= ... side effects
  println(aVariable)

  //Instructions(DO) vs Expressions(VALUE WITH TYPE)

  //IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //If expression not a if instruction
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while(i < 10){
    println(i)
    i+=1
  }

  //NEVER WRITE THIS AGAIN

  //EVERYTHING IN SCALA IS EXPRESSION

  val aWeirdValue = (aVariable = 3) //Unit === void
  println(aWeirdValue)

  //side effects: println(), whiles(), reassigning

  //code blocks
  val aCodeBlock: String = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }
  //code block is an expression
  //type if all block - type of last expression in this block

  //1) What is the difference between "hello world" and println("hello world")?
  //Answer: first - is an expression, second - is an a side effect

  //2)What's the value of this guys?
  val someValue = {
    2 < 3
  }
  //Answer: Boolean

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  //Answer: Int
}
