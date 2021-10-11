package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  //create success and failure
  val aSuccess: Success[Int] = Success(3)
  val aFailure: Failure[Int] = Failure(new RuntimeException("super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod: String = throw new RuntimeException("No string for u")

  // This is what we construct Try object's via apply() method
  val potentialFailure: Try[String] = Try(unsafeMethod)
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialfailure = Try {
    // some code that might throw
  }

  // utilities
  println(potentialFailure.isFailure)

  // orElse
  def backupMethod: String = "A valid result"

  val fallbackTry = Try(unsafeMethod) orElse Try(backupMethod)
  println(fallbackTry)

  // If you design the API
  def betterUnsafeMethod: Try[String] = Failure(throw new RuntimeException("better no string for u"))

  def betterBackupMethod: Try[String] = Success("A valid value")

  def betterFallback: Try[String] = betterUnsafeMethod orElse betterBackupMethod

  // map, flatMap, filter
  println(aSuccess.map(_ * 3))
  println(aSuccess.flatMap(x => Success(x * 6)))
  println(aSuccess.filter(_ > 4))
  // => for-comprehensions

  /*
  Exercise with host and port
   */

  val host: String = "localhost"
  val port: String = "8080"
  val url: String = "https://simple_sus.com"

  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>" else throw new RuntimeException("Can't configure html page")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection else throw new RuntimeException("port is already taken")
  }

  //First variant
  Try(HttpService.getConnection(host, port)).map(_.get(url)).foreach(println)

  //Second variant
  for {
    connection <- Try(HttpService.getConnection(host, port))
    page <- Try(connection.get(url))
  } renderHTML(page)

}
