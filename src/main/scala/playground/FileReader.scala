package playground

object FileReader extends App {
  import scala.io.Source

  def readFile(path: String = args(0)): Unit =
    if(path.nonEmpty) Source.fromFile(path).getLines().toList.foreach{x =>
      println(f"${x.length}%4d | ${x.trim}")}
    else Console.err.println("Please input path")

  def readFile2(path: String): Unit = if(path.nonEmpty){
    val lines: List[String] = Source.fromFile(path).getLines().toList
    lines.foreach(x =>
      println(" " * (lines.map(_.trim.length).max.toString.length - x.length.toString.length) + x.length + " | " + x))
  } else Console.err.println("Please input path")

  readFile2("/home/nikita/IdeaProjects/rock-the-jvm-scala-functional-programming/src/main/scala/playground/FileReader.scala")
}
