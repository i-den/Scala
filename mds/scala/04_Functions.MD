#### Local Functions
 - doesn't pollute global ns
```scala
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
```

### First Class functions

Function Literals
```scala
val increaseByOne = (i: Int) => i + 1
val eleven = increaseByOne(10)
```
multiline literal
```scala
val increaseByTwo = (i: Int) => {
  // some logic
  i + 2
}
```
```scala
val nums = (1 to 10)
// long literal
nums.filter((x: Int) => x % 2 == 0)
// short literal
nums.filter(x => x % 2 == 0)

// placeholder syntax
val even = nums.filter(_ % 2 == 0)
// you can even do this
val sum = (_: Int) + (_: Int)
```

#### Partially applied functions
```scala
def sumThreeNumbers = (a: Int, b: Int, c: Int) => a + b + c
sumThreeNumbers(1, 2, 3) // 6
```
general approach
```scala
val proxySum = sumThreeNumbers(_, _, _)
proxySum(1, 2, 3) // 6
```
Given this code, the Scala compiler instantiates a function value that takes 
the three integer parameters missing from the partially applied function expression,
sum(_, _, _), and assigns a reference to that new function value
to the variable proxySum


#### Partially
```scala
// partially comes from
val addFour = sumThreeNumbers(1, _, 3)
addFour(5) // 9
```

#### Closures
General closures
```scala
var toAdd = 1
val addSome = (n: Int) => n + toAdd
addSome(5) // 6

// can mutate
toAdd = 2  // mutates var used by closure
addSome(5) // 7
```
With mutation
```scala
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
```

#### Repeated Parameters
Inside the function, the type of the repeated parameter is a Seq of the declared type of the parameter.

Thus, the type of args inside the echo function, which is declared as type “String*” is actually Seq[String].
```scala
// String* -> type Seq[String]
def echo(args: String*): Unit = {
  for (a <- args) {
    println(a)
  }
}
```
```scala
echo("First Line")
// First Line

echo("First Line", "Second Line")
// First Line
// Second Line
```

Using the Seq
```scala
val words: Seq[String] = Seq("First Line", "Second Line")
echo(words*) // * here
// First Line
// Second Line
```

#### By name / By value
```scala
def calledByValue(x: Long): Unit = {
  println("By Value - " + x)
  println("By Value - " + x)
}

def calledByName(x: => Long): Unit = {
  println("By Name - " + x)
  println("By Name - " + x)
}

// evaluated when calling
println(calledByValue(System.nanoTime()))
// By Value - 2425550131100
// By Value - 2425550131100

// evaluated when used by the function (each time it is used in the function)
println(calledByName(System.nanoTime()))
//  By Name - 2425553418800
//  By Name - 2425554221600
```