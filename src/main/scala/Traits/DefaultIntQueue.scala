package com.idenchev.exercises.fp
package Traits

import scala.collection.mutable.ArrayBuffer

class DefaultIntQueue extends IntQueue {

  private val buf = ArrayBuffer.empty[Int]

  def get(): Int = {
    buf.remove(0)
  }

  def put(n: Int): Unit = {
    buf += n
  }
}
