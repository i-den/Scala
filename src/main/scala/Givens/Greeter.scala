package com.idenchev.exercises.fp
package Givens

object Greeter {
  def greet(name: String)(using prompt: PreferredPrompt): Unit = {
    println(s"Welcome, $name. The system is ready.")
    println(prompt.pref)
  }
}
