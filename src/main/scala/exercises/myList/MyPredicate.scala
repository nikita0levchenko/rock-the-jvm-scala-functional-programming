package exercises.myList

trait MyPredicate[-T] {
  def test(value: T): Boolean
}
