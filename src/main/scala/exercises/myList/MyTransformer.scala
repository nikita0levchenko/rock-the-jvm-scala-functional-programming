package exercises.myList

trait MyTransformer[-A, B] {
  def convert(value: A): B
}
