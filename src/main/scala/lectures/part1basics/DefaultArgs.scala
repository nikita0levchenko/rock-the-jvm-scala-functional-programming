package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFac(n: Int, acc: Int = 1): Int =              // default value for argument
    if(n == 1) acc else trFac(n - 1, n * acc)
  println(trFac(5))                                   // 120

  def savingPicture(format: String = "jpeg", width: Int, height: Int): Unit = println("saving...")
  savingPicture(width = 800, height = 640)
  savingPicture("png", 1920, 1080)

  /*
  1) name the arguments
  2) pass in every landing argument
   */
}
