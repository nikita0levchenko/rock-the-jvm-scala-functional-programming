package lectures.part2.oop

object Objects {
  //SCALA DOES NOT HAVE A CLASS-LEVEL FUNCTIONALITY("static")
  object Person {  // type + it's only instance
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother: Person, father: Person): Person = new Person("Bobby") // factory method
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  //COMPANIONS class Person and object Person are companions

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val tom = Person
    println(mary == tom) // true

    val mary1 = new Person("Mary")
    val tom1 = new Person("Thomas")
    println(mary1 == tom1)

    val bobbie = Person(mary1, tom1)

    // Scala applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
