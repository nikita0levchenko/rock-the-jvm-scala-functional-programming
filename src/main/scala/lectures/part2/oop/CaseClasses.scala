package lectures.part2.oop

object CaseClasses extends App {
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  //1) Promoted to fields
  val jim = Person("Jim", 34)
  println(jim.name)
  println(jim.age)

  //2) Sensible toString()
  println(jim.toString)
  //syntactic sugar
  println(jim) // == the same as above

  //3) equals and hashCode implemented from the box
  val jim2 = Person("Jim", 34)
  println(jim == jim2)

  //4) Have copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5) Have companion objects
  val thePerson = Person

  val mary = Person("mary", 18)

  //6) Case classes are serializable
  // Extremely useful when you use
  // Akka

  //7) Case classes have extractor patterns == Case classes cn be used in PATTERN MATCHING

  // Case-objects

  case object UnitedKingdom {
    def name: String = "United kingdom of GB and NI"
  }

  // the same property as case classes but without companion objects

  /*
  Expand MyList - use case classes and case objects
   */
}
