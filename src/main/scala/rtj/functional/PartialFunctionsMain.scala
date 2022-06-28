package com.idenchev.exercises.fp
package rtj.functional

object PartialFunctionsMain extends App {

  // Takes all Integers
  val aFunction = (x: Int) => x + 1

  // Might use something like
  val aFussyFunction = (x: Int) => {
    if (x == 1) 42
    else if (x == 2) 422
    else throw new FunctionNotApplicableException
  }

  class FunctionNotApplicableException extends RuntimeException

  // Takes (1, 2) as domain
  // This is a Proper function of Int to Int
  // accepts only a part of the Int domain
  val aBetterFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 422
  }

  // Partial Function literal
  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 422
  }

  // Partial Function utilities
  aPartialFunction.isDefinedAt(3) // false

  // Lift -> wraps in an Option
  val lifted = aPartialFunction.lift
  lifted(3) // None

  // Chain
  val chained = aPartialFunction.orElse[Int, Int] {
    case 3 => 4222
  }
}
