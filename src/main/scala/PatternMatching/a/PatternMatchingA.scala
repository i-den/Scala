package com.idenchev.exercises.fp
package PatternMatching.a

object PatternMatchingA extends App {


  def simplifyTop(expr: Expr): Expr = {
    expr match
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Num(0)) => e
      case BinOp("*", e, Num(1)) => e
      case _ => expr
  }

  def describe(x: Any): String = {
    x match
      case 5 => "Five"
      case true => "The Truth"
      case "hello" => "A Greeting"
      case _ => "Nothing of the above"
  }
}
