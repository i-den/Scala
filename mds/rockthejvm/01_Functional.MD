All scala functions are objects

#### map, flatMap, filter, for-comprehension
```scala
// nested fors
for () { for () {} }
```
```scala
// flatMap & map combo
val a = List(1, 2)
val b = List('a', 'b')
val c = List("red", "blue")

a.flatMap(num => b.flatMap(character => c.map(color => s"$color $character $num")))
// List(red a 1, blue a 1, red b 1, blue b 1, red a 2, blue a 2, red b 2, blue b 2)
```
Slightly unreadable, can use for-comprehensions
```scala
// for-comprehension of the above
val forCombinations = for {
  num <- a
  character <- b
  color <- c
} yield s"$color $character $num"
// List(red a 1, blue a 1, red b 1, blue b 1, red a 2, blue a 2, red b 2, blue b 2)
```
Can use filters
```scala
val forCombinations = for {
  num <- a if(num % 2 == 0) // if guard
  character <- b
  color <- c
} yield s"$color $character $num"
```
