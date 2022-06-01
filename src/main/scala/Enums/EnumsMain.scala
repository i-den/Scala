package com.idenchev.exercises.fp
package Enums

import Enums.Eastwood.Good

object EnumsMain extends App {
  val d = Direction.East
  println(d.invert()) // West

  val eastwood: Good[Int, Nothing] = Good(41)
  println(eastwood.map(n => n + 1)) // Good(42)
}
