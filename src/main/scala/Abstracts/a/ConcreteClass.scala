package com.idenchev.exercises.fp
package Abstracts.a

class ConcreteClass extends AbstractTrait {
  type T = String

  override def transform(x: String): String = {
    "Hello"
  }

  override val initial: String = "Hi"
  override var current: String = initial
}
