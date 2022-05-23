#### Control Abstractions

##### Reducing Code
```scala
object ControlAbstraction_1 extends App {
  private def localFiles: Array[File] = new File(".").listFiles()
}
```
```scala
def filesEnding(q: String): Array[File] = {
  for (file <- localFiles if file.getName.endsWith(q)) // endsWith
    yield file
}
```
```scala
def filesContaining(q: String): Array[File] = {
  for (file <- localFiles if file.getName.contains(q)) // contains
    yield file
}
```
```scala
def filesRegex(q: String): Array[File] = {
  for (file <- localFiles if file.getName.matches(q)) // matches
    yield file
}
```
<hr/>

Generalize
```scala
def filesMatching(q: String, matcher: (String, String) => Boolean): Array[File] = {
  for (file <- localFiles if matcher(file.getName, q))
    yield file
}
```

Refactor
```scala
def filesEnding(q: String): Array[File] = {
  filesMatching(q, (fileName, q) => fileName.endsWith(q))
}

def filesContaining(q: String): Array[File] = {
  filesMatching(q, (fileName, q) => fileName.contains(q))
}

def filesRegex(q: String): Array[File] = {
  filesMatching(q, (fileName, q) => fileName.matches(q))
}
```

Abstract Further
```scala
def filesMatching(matcher: String => Boolean): Array[File] = {
  for (file <- localFiles if matcher(file.getName))
    yield file
}
```
```scala
def filesEnding(q: String): Array[File] = {
  filesMatching(fileName => fileName.endsWith(q))
}

def filesContaining(q: String): Array[File] = {
  filesMatching(fileName => fileName.contains(q))
}

def filesRegex(q: String): Array[File] = {
  filesMatching(fileName => fileName.matches(q))
}
```

#### Currying
```scala
def sumTwoNumbers(x: Int, y: Int): Int = x + y
sumTwoNumbers(1, 2) // 3

def curriedSumTwoNumbers(x: Int)(y: Int): Int = x + y
curriedSumTwoNumbers(1)(2) // 3
```
The first function invocation takes a single Int parameter named x, and returns a function
value for the second function
```scala
def curriedSum2(x: Int) = (y: Int) => x + y
curriedSum2(1)(2)

def iAddFour = curriedSum2(4)
iAddFour(5) // 9

def doubleCall(fn: Double => Double, z: Double): Double = fn(fn(z))
doubleCall(d => d + d, 1) // 4            1 + 1 = 2        2 + 2 = 4
```




