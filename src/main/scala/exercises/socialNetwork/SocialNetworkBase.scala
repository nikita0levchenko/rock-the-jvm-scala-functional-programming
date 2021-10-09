package exercises.socialNetwork

trait SocialNetworkBase {
  def add(person: String): SocialNetworkBase
  def remove(person: String): SocialNetworkBase
  def friend(person: String, friend: String): SocialNetworkBase
  def unfriend(person: String, unfriended: String): SocialNetworkBase
  def friendsOf(person: String): Set[String]
  def mostFriends: String
  def noFriends: Int
  def isASocialConnection(p1: String, p2: String): Boolean
}
