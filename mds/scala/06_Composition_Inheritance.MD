#### Abstract classes

A class with abstract members must itself be declared abstract, which is done
by writing an abstract modifier in front of the class keyword
```scala
abstract class AbstractElement {
  def contents: Vector[String]
}
```

A method is abstract if it does not have an implementation
(i.e., no equals sign or body)

Methods that have an implementation are called <b>concrete</b>

Class AbstractElement declares the abstract method contents, but currently
defines no concrete methods

<hr/>

Add additional methods
```scala
abstract class AbstractElement {
  def contents: Vector[String]
  
  def height: Int = contents.length
  
  def width: Int = {
    if (height == 0)
      0
    else
      contents(0).length
  }
}
```

<hr/>

None of the methods has parenthesis
```scala
// not
def width(): Int  // empty-paren 
// but is
def width: Int    // parameterless
```

can change methods with vals
```scala
val height = contents.length
val width = if height == 0 then 0 else contents(0).length
```

clients of the AbstractElement class should not be affected
when its internal implementation changes

In particular, a client of class AbstractElement should not need to be rewritten
if a field of that class gets changed into an access function, so long as the
access function is pure

Scala 3 is very liberal when it comes to mixing parameterless
and empty-paren methods defined in Java or Scala 2. 

In particular,
you can override a parameterless method with an empty-paren method, and
vice versa, so long as the parent class was written in Java or Scala 2. 

You can also leave off the empty parentheses on an invocation of any function defined
in Java or Scala 2 that takes no arguments
```scala
"hello".length // no () because no sideeffect
println() // better to not drop the ()
```

<b>To summarize, it is encouraged in Scala to define methods that take no parameters
and have no side effects as parameterless methods (i.e., leaving off
the empty parentheses).

On the other hand, you should never define a method
that has side-effects without parentheses, because invocations of that method 
would then look like a field selection. So your clients might be surprised to
see the side effects </b>

#### Extending classes
```scala
class VectorElement(c: Vector[String]) extends AbstractElement {
  override def contents: Vector[String] = c
}
```
- VectorElement inherits all non-private members
- VectorElement a subtype of AbstractElement

```scala
val ve = VectorElement(Vector("hello", "world"))
println(ve.width) // 5
```

#### Invoking super()
```scala
class LineElement(s: String) extends VectorElement(Vector(s)) {}
```

#### Companion obj
