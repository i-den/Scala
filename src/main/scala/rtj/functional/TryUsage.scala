package com.idenchev.exercises.fp
package rtj.functional

import scala.util.{Failure, Success, Try}

object TryUsage extends App {

  val aSuccess = Success(7)
  val aFailure = Failure(new RuntimeException("Failure"))

  def unsafeMethod(): String = throw new RuntimeException("Failed Method Call")

  def backupMethod(): String = "Successful calc"

  // Failure(java.lang.RuntimeException: Failed Method Call)
  val potentialFailure = Try(unsafeMethod())

  val bkp = Try(unsafeMethod()).orElse(Try(backupMethod()))


}
