package lectures.part4pm

import exercises.myList.{EmptyList, ListImp, MyList}

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1              => "a number"
    case "Scala"        => "The Scala"
    case true           => "The truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 - wildcard
  val matchWildcard: Unit = x match {
    case _ =>
  }

  //2.2 - a variable
  val matchVariable: Unit = x match {
    case something => s"I've found $something"
  }

  //3 - tuples
  val aTuple: (Int, Int) = (1,2)
  val aMatchedTuple = aTuple match {
    case (1, 1) => "one and one"
    case (1, something) => s"I've found $something"
  }

  val aNestedTuple: (Int, (Int, Int)) = (1,(2,3))
  val aMatchedNestedTuple = aNestedTuple match {
    case (_, (_, 3)) => "Three"
  }
  // PMs can be nested

  //4 - case classes - constructor pattern
  // PMs can be nested with case classes as well
  val aList: MyList[Int] = ListImp(1, ListImp(2, ListImp(3, EmptyList)))
  val aMatchedList = aList match {
    case EmptyList => "Empty"
    case ListImp(head, _) => s"$head"
  }

  //5 - List patterns
  val aStandardList = List(1,2,3,42)
  val aListmatch: Unit = aStandardList match {
    case List(1,_, _, _) => //extractor - advanced
    case List(1, 2, _*)  => //list of arbitrary length
    case 1 :: List(_)    => //infix pattern
    case List(_) :+ 42   => //infix pattern to
  }

  //6 - type specifiers
  val unknown: Any = 2
  val unknownMatch: Unit = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ => "oh no..."
  }

  //7 - name binding
  val nameBindingMatch: Unit = aList match {
    case aMatchedList @ ListImp(_, _) => // name binding. You can use this name later(here)
    case ListImp(1, rest @ ListImp(2, _)) => // name binding inside nested pattern matching
    case _ => "oh no..."
  }

  //8 - multi-patterns
  val aSimpleInt = 2
  val aSimpleString = "Str"
  def multipattern(value: Any): Any = value match {
    case 2 | "Str" => "YEAH!"
    case _ => "Oh no..."
  }
  println(s"multipattern: ${multipattern(aSimpleInt)}")
  println(s"multipattern: ${multipattern(aSimpleString)}")

  //9 - if guards
  val secondElementSpecial = aList match {
    case ListImp(_, ListImp(specialElement, _)) if specialElement % 3 == 0 =>
    case _ => "oh no..."
  }

  // ALL

  /*
  Trick question
   */

  val simpleList = List(1,2,3)
  val simpleListMatch = simpleList match {
    case listOfStrings: List[String] => "A list of strings"
    case listOfInts: List[Int] => "A list of ints"
    case _ => ""
  }

  // True answer is a "A list of strings", because type erasure in JVM
}
