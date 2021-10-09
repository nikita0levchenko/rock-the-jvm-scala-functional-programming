package lectures.part3fp

object AnonymousFunctions extends App{

  // anonymous function (Lambda)
  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  // no params
  val doSomeThing: () => String = () => "Hi"

  //caredul
  println(doSomeThing)
  println(doSomeThing())

  // curly braces with lambdas
  val stringToInt: String => Int = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /*
  1) In MyList replace all FunctionX calls with lambdas
  2) Rewrite the sum
   */
}
