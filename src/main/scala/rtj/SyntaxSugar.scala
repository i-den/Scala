package com.idenchev.exercises.fp
package rtj

import scala.util.Try

object SyntaxSugar extends App {

  // 1: Methods with single parameters
  def singleArgMethod(arg: Int): String = s"$arg here"

  // called with {}
  val desc = singleArgMethod {
    5
  }

  // examples
  val aTryInstance = Try { throw new RuntimeException() }
  List(1, 2, 3).map{ m => m + 3 }

  // 2: traits with single methods can be reduced to lambda
  trait Action {
    def act(a: Int): Int
  }

  // Single Abstract Method
  val inst: Action = (a: Int) => a + 5

  // 3: :: and #:: methods
  val prependedList = 2 :: List(3, 4)
  // compiled as List(3,4) :: 2
  // methods ending in a : are right associative

  // 4: Infix Types
  class Composite[A, B]
  val c: Composite[Int, String] = ???
  val cc: Int Composite String = ???

  // 5: update()
  val arr = Array(1, 2, 3)
  arr(2) = 7
  // rewritten to arr.update(2, 7)
}
