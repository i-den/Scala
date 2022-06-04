package com.idenchev.exercises.fp
package Abstracts.b

abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood): Unit
}
