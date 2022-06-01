#### List
- immutable
- singly linked lists
- fast ops to first ele / good for pattern matching

#### ListBuffer
- mutable
- fast ops of adding at the end as well
- can prepend, append and then use .toList
```scala
import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1 // ListBuffer(1)
buf += 2 // ListBuffer(1, 2)
3 +=: buf // ListBuffer(3, 1, 2)
buf.toList // List(3, 1, 2)
```

#### Array
- idx access
```scala
// do not know vals
val fiveInts = new Array[Int](5) // Array(0, 0, 0, 0, 0)

// know vals
val fiveToOne = Array(5, 4, 3, 2, 1) // Array(5, 4, 3, 2, 1)
```

#### ArrayBuffer
- mutable
```scala
val buf = new ArrayBuffer[Int]()

buf += 12 // ArrayBuffer(12)
buf += 15 // ArrayBuffer(12, 15)
```

#### StringOps
One other sequence to be aware of is StringOps, which implements many
sequence methods. Because Predef has an implicit conversion from String
to StringOps, you can treat any string like a sequence.
```scala
def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("Robert Frost") // true
hasUpperCase("e e cummings") // false
```

<hr/>

### Sets and Maps

```scala
val muta = mutable.Map("i" -> 1, "ii" -> 2)
val immu = muta to Map
```