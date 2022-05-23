package com.idenchev.exercises.fp
package ControlAbstraction

object ControlAbstraction_Main extends App {

  def sumTwoNumbers(x: Int, y: Int): Int = x + y
  sumTwoNumbers(1, 2) // 3

  def curriedSumTwoNumbers(x: Int)(y: Int): Int = x + y
  curriedSumTwoNumbers(1)(2) // 3

  def curriedSum2(x: Int) = (y: Int) => x + y
  curriedSum2(1)(2)

  def iAddFour = curriedSum2(4)
  iAddFour(5) // 9

  def doubleCall(fn: Double => Double, z: Double): Double = fn(fn(z))
  doubleCall(d => d + d, 1) // 4            1 + 1 = 2        2 + 2 = 4

}
