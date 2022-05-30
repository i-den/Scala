#### Traits
A trait encapsulates
method and field definitions, which can then be reused by mixing them into
classes

Most-common usage:
- widening thin interfaces to rich ones
- defining stackable modifications

Simple trait

It does not declare a superclass, so
like a class, it has the default superclass of AnyRef
```scala
trait Philosophical {
  def philosophize(): String = "I consume memory..."
}
```
#### using Extends
- in that case you implicitly inherit the trait’s superclass
```scala
class Frog extends Philosophical {
  override def toString: String = "Green Frog"
}
```
```scala
val f: Philosophical = new Frog
println(f.philosophize()) // I consume memory...
```

Can also extend a class in addition
```scala
class Animal {}
```
```scala
class Frog extends Animal, Philosophical {
  override def toString: String = "Green Frog"
}
```

Overriding
```scala
class Frog extends Animal, Philosophical {
  override def toString: String = "Green Frog"
  override def philosophize(): String = s"Overriding phil() ${this.toString()}"
}
```
```scala
object TraitsMain extends App {
  val f: Philosophical = new Frog
  println(f.philosophize()) // Overriding phil() Green Frog
}
```

The key difference between classes and traits is that whereas in classes, super calls are statically bound, in traits, they are dynamically bound.

If you write “super.toString” in a class, you know exactly which method implementation will be invoked

When you write the same thing in a trait, however, the method implementation to invoke for the super call is undefined when you define the trait

Rather, the implementation to invoke will be determined anew each time the trait is mixed into a concrete class

This curious behavior of super is key to allowing traits to work as <b>stackable modifications</b>

<hr/> 

<hr/> 

#### Thin vs Rich interfaces
One major use of traits is to automatically add methods to a class in terms of methods the class already has

That is, traits can enrich a thin interface, making it into a rich interface

<hr/> 

##### Rich
A rich interface has many methods, which make it convenient for the caller

Clients can pick a method that exactly matches the functionality they need

<hr/> 

##### Thin
A thin interface, on the other hand, has fewer methods, and thus is easier on the implementers

A thin interface, on the other hand, has fewer
methods, and thus is easier on the implementers. Clients calling into a thin
interface, however, have to write more code. Given the smaller selection of
methods to call, they may have to choose a less than perfect match for their
needs and write extra code to use it.

<hr/>

Adding a concrete method to a trait tilts the thin-rich trade-off heavily
towards rich interfaces, because it is is a one-time effort. You only need to
implement the concrete method once, in the trait itself, instead of needing to
reimplement it for every class that mixes in the trait. Thus, rich interfaces
are less work to provide in Scala than in a language without traits

Enriching
```scala
class Rational(n: Int, d: Int):
  def < (that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def > (that: Rational) = that < this
  def <= (that: Rational) = (this < that) || (this == that)
  def >= (that: Rational) = (this > that) || (this == that)
```
Additional methods relying on the < method

#### Stackable Modifications

Abstract
```scala
abstract class IntQueue {
  def get(): Int
  def put(n: Int): Unit
}
```
Default impl
```scala
class DefaultIntQueue extends IntQueue {

  private val buf = ArrayBuffer.empty[Int]

  def get(): Int = {
    buf.remove(0)
  }

  def put(n: Int): Unit = {
    buf += n
  }
}
```
```scala
  val q1 = new DefaultIntQueue
  q1.put(1)
  q1.put(2)
  println(q1.get()) // 1
  println(q1.get()) // 2
```

Adding in a Trait
```scala
// This declaration means that the trait 
// can only be mixed into a class that also extends IntQueue
trait DoublingIntQueue extends IntQueue {
  // Since super calls in a trait are dynamically bound, the super call in
  // trait Doubling will work so long as the trait is mixed in after another trait or
  // class that gives a concrete definition to the method
  abstract override def put(n: Int): Unit = {
    super.put(n * 2)
  }
}
```
This arrangement is frequently needed with traits that implement stackable modifications

To tell the compiler you are doing this on purpose, you must mark such methods as abstract override

Composing
```scala
val doubleComposed = new DefaultIntQueue with DoublingIntQueue
doubleComposed.put(1) // will become 2
println(doubleComposed.get())
```
calls
```
doubleComposed.put -> DoublingIntQueue.put -> DefaultIntQueue.put
```

Further composing
Calls from right to left
```scala
val q2 = new DefaultIntQueue with IncrementingIntQueue with PositiveIntQueue
q2.put(-1)
q2.put(0)
q2.put(1)
println(q2.get()) // 1
println(q2.get()) // 2
```

