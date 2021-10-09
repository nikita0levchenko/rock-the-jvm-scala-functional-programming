package lectures.part3fp

import scala.util.Random

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // work with unsafe APIs
  def unsafeMethod(): String = null
  //val result: Option[String] = Some(unsafeMethod()) // WRONG!
  val result: Option[String] = Option(unsafeMethod()) // Some of None
  println(result)

  // chained methods
  def backupMethod: String = "A valid result"
  val chainedResult: Option[String] = Option(unsafeMethod()).orElse(Option(backupMethod))
  println(chainedResult)

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedresult: Option[String] = betterUnsafeMethod() orElse betterBackupMethod()


  // functions on options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe because None.get will throw NoSuchElementException

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ % 2 != 0))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions
  val res: Option[Int] = for {
    x <- myFirstOption
    y <- myFirstOption.map(_ * 10)
  } yield x * y

  println(res)

  /*
  Exercise
   */

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "8080"
  )

  class Connection {
    def connected: String = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if(random.nextBoolean()) Some(new Connection) else None
  }

  // try to establish a connection, if so - print the connect method
  // chained calls
  config.get("host")
    .flatMap(h => config.get("post")
      .flatMap(p => Connection(h, p)))
    .map(_.connected).foreach(println)

  // for-comprehensions
  val connectionStatus: Option[String] = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connected
  connectionStatus.foreach(println)

}
