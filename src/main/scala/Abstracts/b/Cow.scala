package com.idenchev.exercises.fp
package Abstracts.b

class Cow extends Animal {
  override type SuitableFood = Grass

  override def eat(food: Grass): Unit = {
    println("Eats Grass")
  }
}
