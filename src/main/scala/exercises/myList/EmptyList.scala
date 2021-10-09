package exercises.myList

case object EmptyList extends MyList[Nothing] {
  override def head: Nothing = throw new NullPointerException("List is empty")

  override def tail: Nothing = throw new NullPointerException("List is empty")

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](elem: B): MyList[B] = ListImp(elem, this)

  override def toString: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = EmptyList

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = EmptyList

  override def zipWith[B, C](list: MyList[B], f: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("The lists don't have same length") else EmptyList

  override def fold[B](acc: B)(f: (B, Nothing) => B): B = acc
}
