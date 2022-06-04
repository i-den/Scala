```scala
trait AbstractTrait {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
```
```scala
class ConcreteClass extends AbstractTrait {
  type T = String

  override def transform(x: String): String = {
    "Hello"
  }

  override val initial: String = "Hi"
  override var current: String = initial
}
```

<hr/>

```scala
abstract class Fruit:
  val v: String // ‘v' for value
  def m: String // ‘m' for method
```
```scala
abstract class Apple extends Fruit:
  val v: String
  val m: String // OK to override a ‘def' with a ‘val'
```
```scala
abstract class BadApple extends Fruit:
  def v: String // ERROR: cannot override a ‘val' with a ‘def'
  def m: String
```

<hr/>

```scala
class Food {}
```
```scala
abstract class Animal {
  type SuitableFood <: Food // <: upper bounded to Food
  def eat(food: SuitableFood): Unit
}
```
```scala
val c = new Cow
c.eat(new Grass) // Eats Grass
```

```scala
class Pasture:
  var animals: List[Animal { type SuitableFood = Grass }] = Nil
```
