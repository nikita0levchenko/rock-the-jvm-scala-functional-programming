package lectures.part2.oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    def eat(): Unit = println("nom nom nom")
    // if method/field -is private then subclass can't inherit this method/field
    private def poop(): Unit = println(" poop poop poop")
    poop()
    // if method/field -is protected then you can use method/field only in this class or IN subclasses
    protected def smoke(): Unit = println("Smoking animal, great!")

    val creatureType: String = "None"
  }

  class Cat extends Animal{
    def crunch: Unit = {
      smoke()
      println("crunch")
    }
  }

  val cat = new Cat
  cat.eat()
  // cat.poop() compiller error
  // cat.smoke() you can't invoke smoke() method from cat instance

  //constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding
//  class Dog(override val creatureType: String) extends Animal {
//    override def eat(): Unit = println("Eating dog")
//    //override val creatureType: String = "a Dog"
//  }

  class Dog(dogType: String) extends Animal {
    override val creatureType: String = dogType

    override def eat(): Unit = {
      super.eat()
      println("crunch crunch")
    }
  }
  //The same situation as above
  //You can override fields/methods from superclass directly in constructor

  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  //type substitution
  val unknownAnimal: Animal = new Dog("S0") // polymorphism
  unknownAnimal.eat()

  //overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on field/method
  // 2 - use final on entire class
  // 3 - seal the class = extends class in this file, but preventing extension in other files
}
