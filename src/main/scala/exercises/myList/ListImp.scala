package exercises.myList

case class ListImp[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](elem: B): MyList[B] =
    ListImp(elem, this)

  override def toString: String =
    if (t.isEmpty) s"$h" else s"$h ${t.toString}"

  override def map[B](transformer: A => B): MyList[B] =
    ListImp(transformer(h), t.map(transformer))

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) ListImp(h, t.filter(predicate)) else t.filter(predicate)

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def ++[B >: A](list: MyList[B]): MyList[B] =
    ListImp(h, tail ++ list)

  override def foreach(f: A => Unit): Unit = if (t.isEmpty) f(h) else {
    f(h);
    t.foreach(f)
  }

  override def sort(f: (A, A) => Int): MyList[A] = {
    def insert(value: A, list: MyList[A]): MyList[A] = if (list.isEmpty) ListImp(value, EmptyList) else if (f(value, list.head) <= 0) ListImp(list.head, insert(value, list.tail)) else ListImp(value, EmptyList) ++ list

    val sortedTail = t.sort(f)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("The lists don't have same length")
    else ListImp(f(h, list.head), t.zipWith(list.tail, f))

  override def fold[B](acc: B)(f: (B, A) => B): B = if (t.isEmpty) f(acc, h) else t.fold(f(acc, h))(f)
}
