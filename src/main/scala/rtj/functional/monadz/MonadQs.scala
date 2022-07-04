package com.idenchev.exercises.fp
package rtj.functional.monadz

object MonadQs extends App {

  // Monad
  case class SafeValue[+T](private val internalValue: T) {
    def get: T = synchronized {
      internalValue
    }

    def flatMap[S](transformer: T => SafeValue[S]): SafeValue[S] = synchronized {
      transformer(internalValue)
    }
  }

  // external | BIND / PURE / UNIT
  def bindSafeValue[T](value: T): SafeValue[T] = SafeValue(value)

  // This is ETW
  // Extract
  // Transform
  // Wrap

  // wrap in a monad
  val safeString: SafeValue[String] = bindSafeValue("Scala")
  // extract
  val stringVal = safeString.get
  // transform
  val transformed = stringVal.toUpperCase()
  // wrap again
  val upperSafeString = SafeValue(transformed)

  // ETW using just flatMap
  val upperSafeString2 = safeString.flatMap(str => SafeValue(str.toUpperCase()))





  // Examples of ease of usage
  // you want firstName and lastName to not be null
  case class Person(firstName: String, lastName: String) {
    assert(firstName != null && lastName != null)
  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  // some API
  // returns Person only if both values are not null
  def getPersonNullChecks(firstName: String, lastName: String): Person = {
    if (firstName != null) {
      if (lastName != null) {
        Person(firstName, lastName)
      } else { // no lastName
        return null
      }
    } // no firstName
    null
  }

  // Let's try with Options
  def getPersonBetter(firstName: String, lastName: String): Option[Person] = {
    Option(firstName).flatMap(fn => {
      Option(lastName).flatMap(ln => Some(Person(fn, ln)))
    })
  }

  // Scala specific
  def getPersonForCompr(firstName: String, lastName: String): Option[Person] = {
    for {
      fn <- Option(firstName)
      ln <- Option(lastName)
    } yield Person(fn, ln)
  }
  ///////////////////////////////////////////////////////////////////////////////////////////


  // Monad properties
  // Left identity

  // takes a number, returns List(number, number + 1)
  def twoConsec(x: Int): List[Int] = List(x, x + 1)
  twoConsec(3) // List(3, 4)

  // now, what is List(3).flatMap(twoConsec)
  List(3).flatMap(twoConsec) // // List(3, 4)

  // Monad(x).flatMap(f) == f(x)
  // Monad solves the ETW pattern


  // Right identity
  List(1, 2, 3).flatMap(x => List(x)) // List(1, 2, 3)

  // Monad(x).flatMap(x => Monad(x)) useless -> returns Monad(x)
  // important that monads respect this


  // Property 3 Associativity (ETW-ETW)
  val numbers: List[Int] = List(1, 2, 3)
  val incrementer: Int => List[Int] = (x: Int) => List(x, x + 1)
  val doubler: Int => List[Int] = (x: Int) => List(x, x * 2)

  // if we
  numbers
    .flatMap(incrementer) // List(1, 2,  2, 3,  3, 4)
    .flatMap(doubler)     // List(1, 2,  2, 4 __ 2, 4, 3, 6 __ 3, 6, 4, 8)
  /*
    List(
      incrementer(1).flatMap(doubler) -> 1, 2, 2, 4
      incrementer(2).flatMap(doubler) -> 2, 4, 3, 6
      incrementer(3).flatMap(doubler) -> 3, 6, 4, 8
    )
  */

  // Same as:
  numbers.flatMap(x => incrementer(x).flatMap(doubler))



  numbers.flatMap(incrementer).flatMap(doubler)
  numbers.flatMap(x => incrementer(x).flatMap(doubler))

  // Monad(v).flatMap(f).flatMap(g) == Monad(v).flatMap(v => f(v).flatMap(g))
}
