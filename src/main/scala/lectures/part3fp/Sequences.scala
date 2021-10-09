package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSeq: Seq[Int] = Seq(1,2,3,4)
  println(aSeq)
  println(aSeq.reverse)
  println(aSeq(2))
  println(aSeq ++ Seq(5,6,7))
  println((aSeq ++ Seq(7,6,5)).sorted)

  // Range
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)
  val untilRange: Seq[Int] = 1 until 10
  untilRange.foreach(println)

  (1 to 10).foreach(x => println("Hello!"))

  // List
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89
  println(prepended)
  val fiveApples: List[String] = List.fill(5)("Apples")
  println(aList.mkString("-"))

  // Arrays
  val numbers: Array[Int] = Array(1,2,3,4)
  val threeElements: Array[String] = Array.ofDim[String](3)
  threeElements.foreach(println)
  //mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  numbers.foreach(println)

  // connection between arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors
  val aVector: Vector[Int] = Vector(1,2,3)
  println(aVector)
  //vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getRightTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList: List[Int] = (1 to maxCapacity).toList
  val numbersVector: Vector[Int] = (1 to maxCapacity).toVector

  println(getRightTime(numbersList))
  println(getRightTime(numbersVector))
  // vector wins

}
