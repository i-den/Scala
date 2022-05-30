package com.idenchev.exercises.fp
package Traits

trait PositiveIntQueue extends DefaultIntQueue {
  abstract override def put(n: Int): Unit = {
    if (n >= 0) {
      super.put(n)
    }
  }
}
