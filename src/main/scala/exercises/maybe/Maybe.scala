package exercises.maybe

abstract class Maybe[+T]{
  def elem: T
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(predicate: T => Boolean): Maybe[T]
}
