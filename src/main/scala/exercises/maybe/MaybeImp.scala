package exercises.maybe

case class MaybeImp[+T](elem: T) extends Maybe[T] {
  override def map[B](f: T => B): Maybe[B] = MaybeImp(f(elem))

  override def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(elem)

  override def filter(predicate: T => Boolean): Maybe[T] = if(predicate(elem)) this else EmptyMaybe
}
