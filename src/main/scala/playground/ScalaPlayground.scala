package playground

import exercises.maybe.{Maybe, MaybeImp}
import exercises.myList.{EmptyList, ListImp}
import exercises.maybe.Maybe
import exercises.myList.EmptyList
import exercises.socialNetwork.SocialNetwork

import scala.Console.println

object ScalaPlayground extends App {
  val testList: ListImp[Int] = ListImp(0, ListImp(1, ListImp(2, ListImp(3, EmptyList))))
  val secondTestList: ListImp[Int] = ListImp(1, ListImp(0, EmptyList))
  val thirdTestList = secondTestList.copy()
  val strList = ListImp("fst", ListImp("snd", ListImp("thd", EmptyList)))
//  println(testList.map(new MyTransformer[Int, Int] {
//    override def convert(value: Int): Int = value * 2
//  }).toString)
//
//  println(testList.map(new MyTransformer[Int, String] {
//    override def convert(value: Int): String = s"$value+"
//  }).toString)
//
//  println(testList.filter(new MyPredicate[Int] {
//    override def test(value: Int): Boolean = value % 2 == 0
//  }).toString)
//
//  println(testList ++ secondTestList)
//
//  println(testList.flatMap(new MyTransformer[Int, MyList[Int]] {
//    override def convert(value: Int): MyList[Int] = ListImp(value, ListImp(value * 2, EmptyList))
//  }).toString)

  println(testList map (_ * 2) )
  println(testList map (_.toString + "+") )
  val forListTest = for {
    elem <- testList
  } yield s"${elem.toString}+"
  println(s"THIS IS FOR-COMP CHECK: $forListTest")
  println(testList filter (_ % 2 == 0))
  println(testList flatMap(elem => ListImp(elem, ListImp(elem * 2, EmptyList))))
  println(secondTestList == thirdTestList)
  println("--------------------/ HOF and Curries task 1.1 /--------------------")
  testList.foreach(println)
  EmptyList.foreach(println)
  println("--------------------/ HOF and Curries task 1.2 /--------------------")
  testList.sort(_ - _).foreach(println)
  println("--------------------/ HOF and Curries task 1.3 /--------------------")
  secondTestList.zipWith(secondTestList, (x: Int, y: Int) => x.toString + y.toString).foreach(println)
  println("--------------------/ HOF and Curries task 1.4 /--------------------")
  println(testList.fold(0)(_ + _))
  println(strList.fold("")((x:String, y: String) => x + y.tail))

  val maybe: Maybe[Int] = MaybeImp(1)
  val innerMaybe:Maybe[Int] = maybe.flatMap(x => MaybeImp(x * 3))
  println(maybe.map(_ * 2).elem)
  println(innerMaybe.elem)
  println(maybe.filter(_ % 2 == 0))

  println("--------------------/ Tuples and Maps task 2 /-----------------------")
  val socialNetwork: SocialNetwork = SocialNetwork(
    Map(
      "Nikita L." -> Set("Andrew T.", "Pavel G.", "Oleg B.", "Andrew K.", "Ilya D."),
      "Andrew T." -> Set("Nikita L.", "Pavel G.", "Oleg B."),
      "Andrew K." -> Set("Nikita L.", "Oleg B.", "Ilya D.", "Anton M."),
      "Noname" -> Set(),
      "Nameno" -> Set()
    )
  )

  println("#################_ADD_TESTS_#################")
  println(socialNetwork.add("Knight"))
  println("#################_REMOVE_TESTS_#################")
  println(socialNetwork.remove("Nikita L."))
  println("#################_FRIEND_#################")
  println(socialNetwork.friend("Nikita L.", "Nikita Z."))
  println(socialNetwork.friend("Nikita L.", "Noname"))
  println("#################_UNFRIEND_#################")
  println(socialNetwork.unfriend("Andrew T.", "Nikita L."))
  println(socialNetwork.unfriend("Andrew T.", "Pavel G."))
  println("#################_FRIENDS_OF_#################")
  println(socialNetwork.friendsOf("Nikita L."))
  println("#################_MOST_FRIENDS_#################")
  println(socialNetwork.mostFriends)
  println("#################_NO_FRIENDS_#################")
  println(socialNetwork.noFriends)
  println("#################_IS_A_SOCIAL_CONNECTION_#################")
  println(socialNetwork.isASocialConnection("Andrew T.", "Anton M."))
  }
