package com.idenchev.exercises.fp
package Abstracts

import Abstracts.b.{Cow, Grass}

object AbstractMain extends App {
  val c = new Cow
  c.eat(new Grass) // Eats Grass
}
