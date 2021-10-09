package playground

import scala.annotation.tailrec
import scala.math.{pow, log10}

object Zeros extends App {

  def zeros(n: Int): Int = {
    @tailrec
    def loop(k: Int, kMax: Int, acc: Int = 0): Int =
      if (k > kMax) acc else loop(k + 1, kMax, acc + (n / (pow(5, k)).floor.toInt))
    loop(1, (log10(n) / log10(5)).floor.toInt)
  }

  @tailrec
  def triangular(n: Int, acc: BigInt = 0): BigInt = if (n == 0) acc else triangular(n - 1, acc + n)


   println(triangular(3)) // 3 6
}
