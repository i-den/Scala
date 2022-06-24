package com.idenchev.exercises.fp
package rtj

object WhatsFunction extends App {

  val a = List(1, 2)
  val b = List('a', 'b')
  val c = List("red", "blue")

  a.flatMap(num => b.flatMap(character => c.map(color => s"$color $character $num")))

  // for-comprehension of the above
  val forCombinations = for {
    num <- a
    character <- b
    color <- c
  } yield s"$color $character $num"

  a.map(num => b.map(character => s"$character $num"))

  val m: Map[String, List[String]] = Map("Gosho" -> List("1", "2", "3"),
    "Azx" -> List()
  )

  m + ("Asd" -> List())
}
