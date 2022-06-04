package com.idenchev.exercises.fp
package Abstracts.a

trait AbstractTrait {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
