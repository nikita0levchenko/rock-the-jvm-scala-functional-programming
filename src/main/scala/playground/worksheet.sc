import scala.annotation.tailrec

def duplicateCount(str: String): Int = str.groupBy(identity).mapValues(_.length).count(_._2 > 1)

def bouncingBall(h: Double, bounce: Double, window: Double): Int = {
  def reverse(reversed: Double): Int = if(reversed > window) 1 else 0
  def loop(curr: Double, acc: Int = 1):Int = curr * bounce match {
    case elem if(elem > window) => loop(elem, acc + 1 + {if(elem * bounce > window) 1 else 0})
    case _                      => acc
  }
  if(bounce >= 1 || window >= h || bounce < 0) -1 else loop(h)
}

def count(string: String): Map[Char,Int] = string.groupBy(identity).mapValues(_.length).toMap