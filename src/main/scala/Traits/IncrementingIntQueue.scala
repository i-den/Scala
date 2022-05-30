package com.idenchev.exercises.fp
package Traits

trait IncrementingIntQueue extends DefaultIntQueue {
  abstract override def put(n: Int): Unit = {
    super.put(n + 1)
  }
}
