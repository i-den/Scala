package com.idenchev.exercises.fp
package ListsMod

object ListsMain extends App {

  val fruits = "apples" :: ("oranges" :: ("pears" :: Nil)) // List(apples, oranges, pears)

  val others = List("1", "2", "3")

  val thirds = fruits ::: others
  // List(apples, oranges, pears, 1, 2, 3)

  thirds.zipWithIndex
  // List((apples,0), (oranges,1), (pears,2), (1,3), (2,4), (3,5))

  thirds.mkString("[", ",", "]")
  // [apples,oranges,pears,1,2,3]

  val z = List.range(1, 5) // List(1, 2, 3, 4)

  List(1, 2, 3, 4, 5).partition(_ % 2 == 0)
  // (List(2, 4),List(1, 3, 5))

  val s = List("a", "b", "c", "c").toSet
  println(s)


}
