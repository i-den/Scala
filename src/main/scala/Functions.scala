package com.idenchev.exercises.fp

object Functions extends App {

  // LOCAL FUNCTIONS
  def publicMethodHere(text: String): String = {
    // Local Function here
    def localFunction(s: String): String = {
      s.toUpperCase
    }

    // Using the local function
    // Available only inside this function
    // Doesn't pollute the namespace of the obj
    localFunction(text)
  }

  // FUNCTION LITERALS
  val increaseByOne = (i: Int) => i + 1
  val eleven = increaseByOne(10)

  // multiline literal
  val increaseByTwo = (i: Int) => {
    // some logic
    i + 2
  }

  val nums = (1 to 10)
  // long literal
  nums.filter((x: Int) => x % 2 == 0)
  // short literal
  nums.filter(x => x % 2 == 0)

  // placeholder syntax
  val even = nums.filter(_ % 2 == 0)
  // you can even do this
  val sum = (_: Int) + (_: Int)


  // PARTIALLY APPLIED FNS
  def sumThreeNumbers = (a: Int, b: Int, c: Int) => a + b + c
  sumThreeNumbers(1, 2, 3) // 6

  // general way
  val proxySum = sumThreeNumbers(_, _, _)
  proxySum(1, 2, 3) // 6

  // partially comes from
  val addFour = sumThreeNumbers(1, _, 3)
  addFour(5) // 9

  // CLOSURE
  var toAdd = 1
  val addSome = (n: Int) => n + toAdd
  addSome(5) // 6

  // can mutate
  toAdd = 2
  addSome(5) // 7

  // Changes made by a closure to a
  // captured variable are visible outside the closure
  var toAddMutated = 1
  val addSomeThatWillMutate = (n: Int) => {
    val added = n + toAddMutated
    toAddMutated = toAddMutated + 1 // mutates out of scope var
    added
  }
  addSomeThatWillMutate(1) // 2
  addSomeThatWillMutate(1) // 3


  // REPEATED PARAMETERS
  def echo(args: String*): Unit = {
    for (a <- args) {
      println(a)
    }
  }

  echo("First Line")
  // First Line

  echo("First Line", "Second Line")
  // First Line
  // Second Line

  val words: Seq[String] = Seq("First Line", "Second Line")
  echo(words*)
  // First Line
  // Second Line

  // NAMED PARAMETERS
  def speed(distance: Double, time: Double): Double = distance / time
  speed(100, 10) // 10.0

  speed(time = 10, distance = 100) // 10.0

  // DEFAULT VALUES
  def greeting(name: String = "Hello"): String = s"$name, my name is..."

  greeting()                    // Hello, my name is...
  greeting("Not Hello")  // Not Hello, my name is...



}
