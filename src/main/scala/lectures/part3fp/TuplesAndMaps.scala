package lectures.part3fp

object TuplesAndMaps extends App {
  //tuples = finite ordered lists
  val aTuple = (2, "hello scala") //Tuple[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap)

  //Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val aPhoneBook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is sugar for (a,b)
  println(aPhoneBook)

  // maps ops
  println(aPhoneBook.contains("Jim"))
  println(aPhoneBook("Mem"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = aPhoneBook + newPairing
  println(newPhoneBook)

  // functions on Maps
  // map, flatMap, filter
  println(newPhoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(aPhoneBook.filter(_._1.startsWith("J")))
  // mapValues
  println(aPhoneBook.map(_._2 + 1))

  // conversions to other collections
  println(aPhoneBook.toList)
  println(List("Mary" -> 1, "Tommy" -> 2).toMap)
  val names: List[String] = List("Nikita", "Pavel", "Andrew", "Oleg", "Vladislav", "Noname", "Anal", "Pidor")
  println(names.groupBy(x => x.toLowerCase().contains('a')))

  /*
  Exercises
  1) What will happen in this situation: Map("Jim" -> 123, "JIM" -> 345).map(_.toLowerCase())
  2) Write a very simplified version of social network, which using a Map
  Person = String
    -add a Person to the network
    -remove
    -friend(mutual)
    -unfriend(mutual)
    -number of friends of a given person
    -person with the most friend
    -how many people have no friends
    -is there is a social connection between two people (direct or not)
   */

  // Exercise 1
  val weirdMap: Map[String, Int] = Map("Jim" -> 1230, "JIM" -> 345)
  println(weirdMap.map(x => (x._1.toLowerCase(), x._2)))

  // Exercise 2
}
