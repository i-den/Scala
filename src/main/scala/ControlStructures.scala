package com.idenchev.exercises.fp

object ControlStructures extends App {

  // FOR
  // generator
  val filesHere = new java.io.File(".").listFiles
  for (file <- filesHere) {
    println(file)
  }

  // Range exclusive
  val rangeExclusive: Range = 1 until 5
  // Using Range (inclusive)
  val rangeInclusive: Range = 1 to 5
  for (i <- 1 to 5) {
    println(i)
  }

  // Filtering
  for (f <- filesHere if f.getName.endsWith(".scala")
                      if true) {
    println(f)
  }

  // the Exception is of type Nothing
  def iCanThrow(n: Int): Int = {
    if (n % 2 == 0) {
      n / 2
    }
    throw new RuntimeException("N must be even")
  }

  // Catching Exceptions
  def catching(n: Int): Int = {
    try {
      throw new RuntimeException("throwing here")
    } catch {
      case ex: RuntimeException => {println()}
      case ex: IndexOutOfBoundsException => {println()}
    }
  }

  def withFinally(n: Int): Int = {
    try {
      return 7
    } finally {
      println("I will also execute")
    }
  }
}
