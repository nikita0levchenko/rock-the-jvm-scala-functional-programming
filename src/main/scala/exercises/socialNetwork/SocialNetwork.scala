package exercises.socialNetwork

case class SocialNetwork(users: Map[String, Set[String]]) extends SocialNetworkBase {

  override def add(person: String): SocialNetworkBase =
    if(users.contains(person)) this else SocialNetwork(users + (person -> Set()))

  override def remove(person: String): SocialNetworkBase =
    SocialNetwork((users - person).map(elem => elem._1 -> elem._2.filter(_ != person)))

  override def friend(person: String, friend: String): SocialNetworkBase =
    users.get(person) match {
      case Some(list) => if(list.contains(friend) && users(friend).contains(person)) this else users.get(friend) match {
        case Some(friendList) => SocialNetwork(users + (person -> (list + friend)) + (friend -> (friendList + person)))
        case None             => SocialNetwork(users + (person -> (list + friend)) + (friend -> Set(person)))
      }
      case None       => throw PersonNotFindException(s"Person $person not found")
    }

  override def unfriend(person: String, unfriended: String): SocialNetworkBase =
    users.get(person) match {
      case Some(list) => if(!list.contains(unfriended) && !unfriended.contains(person)) this else users.get(unfriended) match {
        case Some(unfriendList) => SocialNetwork(users + (person -> list.filter(_ != unfriended)) + (unfriended -> unfriendList.filter(_ != person)))
        case None               => SocialNetwork(users + (person -> list.filter(_ != unfriended)))
      }
      case None       => throw PersonNotFindException(s"Person $person not found")
    }

  override def friendsOf(person: String): Set[String] = users.get(person) match {
    case Some(friends) => friends
    case None          => throw PersonNotFindException(s"Person $person not found")
  }

  override def mostFriends: String = users.maxBy(pair => pair._2.size)._1

  override def noFriends: Int  = users.count(_._2.isEmpty)

  //DFS algorithm need to implement
  override def isASocialConnection(p1: String, p2: String): Boolean = users.get(p1) match {
    case Some(p1List) => users.get(p2) match {
      case Some(p2List) => if(p1List.contains(p2) && p2List.contains(p1)) true else users.values.exists(list => list.contains(p1) && list.contains(p2))
      case None         => if(users(p1).contains(p2)) true else users.values.exists(list => list.contains(p1) && list.contains(p2))
    }
    case None         => throw PersonNotFindException(s"Person $p1 not found")
  }
}
