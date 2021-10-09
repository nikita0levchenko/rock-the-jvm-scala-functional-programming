package lectures.part2.oop

import playground.{Armor, Weapon => Gun}
import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App{

  //package members are accessible by their simple name( class Writer locating in part2.oop
  val writer = new Writer("Daniel", "RockTheJvm", 1997)
  val weapon = new Gun("pistol", "Glock17")
  // you can use full name of class with package path playground.Weapon

  //package object
  sayHello()
  println(PI)

  // imports
  val armor = Armor("kevlar", 10)

  // 1) Use the full name with the package
  val date: java.util.Date = new java.util.Date()
  val sqlDate: java.sql.Date = new java.sql.Date(11, 11, 11)

  // 2) use the aliases for imports
  val anotherDate = new Date()
  val anotherSQLDate = new SQLDate(12,12,12)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
