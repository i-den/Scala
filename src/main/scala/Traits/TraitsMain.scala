package com.idenchev.exercises.fp
package Traits

object TraitsMain extends App {
//  val f: Philosophical = new Frog
//  println(f.philosophize()) // Overriding phil() Green Frog
//
//  val q1 = new DefaultIntQueue
//  q1.put(1)
//  q1.put(2)
//  println(q1.get()) // 1
//  println(q1.get()) // 2

//  // compose
//  val doubleComposed = new DefaultIntQueue with DoublingIntQueue
//  doubleComposed.put(1) // will become 2
//  println(doubleComposed.get())

    val q2 = new DefaultIntQueue with IncrementingIntQueue with PositiveIntQueue
    q2.put(-1)
    q2.put(0)
    q2.put(1)
    println(q2.get()) // 1
    println(q2.get()) // 2
}
