package com.idenchev.exercises.fp
package Givens

import JillsPrefs.prompt

object GivensMain extends App {
  val a = Greeter.greet("Jill")(using JillsPrefs.prompt)
  println(a)
}
