package com.idenchev.exercises.fp
package Traits

trait DoublingIntQueue extends IntQueue {
  abstract override def put(n: Int): Unit = {
    super.put(n * 2)
  }
}
