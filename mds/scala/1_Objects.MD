#### Basic Example
```scala
class MessageAccumulator(var ctorArgDef: Int = 15) {
  var sum = 0
}
// ---------------------------------------
val mac = new MessageAccumulator
```

<hr/>

#### Singleton Objects
Classes in Scala cannot have static members.

Instead, Scala has singleton objects

A singleton object definition looks like a class definition, except instead of the keyword class you use the keyword object

When a singleton object shares the same name with a class, it is called that class’s <b><i>companion object</i></b>.

You must define both the class and its companion object in the same source file

A class and its companion object can access each other’s private members.

```scala
package classes

import scala.collection.mutable
  
// Class Here  
class ChecksumAccumulator:
  private var sum = 0

  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1

// Singleton or 'static' here
object ChecksumAccumulator:
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if cache.contains(s) then
      cache(s)
    else
      val acc = new ChecksumAccumulator // An Instance of the Class,
                                        // not the Singleton obj that is represented by the Object

      for (c <- s) do
        acc.add((c >> 8).toByte)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
  }
```
```scala
println(ChecksumAccumulator.calculate("Every value is an object."))
// -248
```

A singleton object is more than a holder of static methods, however. It is a first-class object.

You can think of a singleton object’s name, therefore, as a
“name tag” attached to the object

<hr/>

### Case Classes
Often when you write a class, you need implementations of methods such as equals, hashCode, toString, accessor methods, or factory methods.
These can be time-consuming and error-prone to write.
Scala offers “case classes,” which can generate implementations of several methods based on the values passed to its primary constructor.

First, the compiler will create a companion object and place a factory method in it named apply
```scala
case class PersonCaseClass(name: String, age: Int) {}

object PersonCaseClass {

  def apply(name: String, age: Int): PersonCaseClass = {
    if name.isEmpty then
    throw new IllegalArgumentException("Name cannot be empty")
    new PersonCaseClass(name.toUpperCase(), age)
  }
}
```
Finally, the compiler adds a copy method to your class and an unapply method to the companion.

