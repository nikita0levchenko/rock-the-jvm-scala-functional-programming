package lectures.part2.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("ahahahaha")
  }
  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("ahahahahahhaha")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hello, my name is $name. How can I help you?")
  }

  val jim: Person = new Person("Jim"){
    override def sayHi: Unit = println("Hello, my name is Jim. How can I be of serve?")
  }

  /*
  Exercises:
  1) Generic trait MyPredicate[-T] with a little method test(value: T): Boolean
  2) Generic trait MyTransformer[-A, B] with a method transform(value: A): B
  3) MyList:
    -map(transformer) => MyList
    -filter(MyPredicate) => MyList
    -flatMap(transformer from A to MyList[B]) => MyList[B]
   */

}
