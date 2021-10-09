package lectures.part2.oop

object Generics extends App {

  class MyList[+A]{
    // use the type A inside the class definition
    def add[B >: A](elem: B): MyList[B] = ??? // MyList[Cat].add(MyList[Dog]) == MyList[Animal]
    /*
    A - Cat
    B - Dog == Animal
    result - MyList[Animal]
     */
  }

  class MyMap[A, B] {
  }

  trait MyTrait[A]{
    // actually works with traits
  }

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]
  val mapIntString = new MyMap[Int, String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers: MyList[Int] = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1) yes List[Cat] extends List[Animal] - COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => We return a list of animals

  // 2) no List[Animals] and  List[Cat] are separate things - INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]  <- error here

  // Opposite relationship(HELL, NO) List[Animal] extends List[Cat] - CONTRAVARIANT
  class Trainer[-A]
  // val contravariantList: ContravariantList[Animal] = new ContravariantList[Cat] <- error here
  val contravariantList1: Trainer[Cat] = new Trainer[Animal]  // <- it's ok

  //bounded types
  class Cage[A <: Animal](animal: A)  //Cage can be created only with animal and with thing which extends an animal class
  val cage = new Cage(new Dog)
  class Car
  // val cage1 = new Cage(new Car) <- It will be a compile error


  //Exercise: Expand a MyList from previous exercise to be generic
}
