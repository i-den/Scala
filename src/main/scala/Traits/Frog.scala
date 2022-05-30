package com.idenchev.exercises.fp
package Traits

class Frog extends Animal, Philosophical {
  override def toString: String = "Green Frog"
  override def philosophize(): String = s"Overriding phil() ${this.toString()}"

}
