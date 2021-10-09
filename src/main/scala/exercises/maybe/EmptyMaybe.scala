package exercises.maybe

case object EmptyMaybe extends Maybe[Nothing] {
  override def elem: Nothing = throw new NullPointerException("Maybe is empty")

  override def map[B](f: Nothing => B): Maybe[B] = EmptyMaybe

  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = EmptyMaybe

  override def filter(predicate: Nothing => Boolean): Maybe[Nothing] = EmptyMaybe
}
