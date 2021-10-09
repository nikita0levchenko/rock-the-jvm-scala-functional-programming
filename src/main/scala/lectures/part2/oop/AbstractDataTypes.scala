package lectures.part2.oop

object AbstractDataTypes extends App {
  // abstract class
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }  // Abstract class can't be instantiated

  class Dog extends Animal {
    override val creatureType: String = "a Dog"
    def eat(): Unit = "nom nom"
  }

  //traits
  trait Carnivore {
    def eat (animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat(): Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc, and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract class
  // 1 - traits do not have constructor's parameters
  // 2 - You can extend only one class, but you can mix multiple traits
  // 3 - traits = describes behaviour. abstract class = describes things(fields/parameters)
}
