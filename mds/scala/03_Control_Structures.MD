```scala
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
```

Exceptions
```scala
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
    case ex: RuntimeException => {}
    case ex: IndexOutOfBoundsException => {}
  }
}
```
Returning from finally is tricky:
```scala
// returns 2
def f(): Int = try return 1 finally return 2

// returns 1
def g(): Int = try 1 finally 2
```

Match Expressions
```scala
val firstArg = if !args.isEmpty then args(0) else ""
firstArg match
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
```

match expressions result in a value
```scala
val firstArg = if !args.isEmpty then args(0) else ""
val friend =
  firstArg match
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
println(friend)
```

