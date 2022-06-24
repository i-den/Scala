```scala
trait Queue[+T] { ... }
```
Prefixing a formal type parameter with a + indicates that subtyping is covariant
(flexible) in that parameter. By adding this single character, you are
telling Scala that you want Queue[String], for example, to be considered a
subtype of Queue[AnyRef]

```scala
trait Queue[T] { ... }
```
then if T is a subtype of type S, this would imply that Queue[S] is a subtype
of Queue[T]

<hr/>

### Variance problem
```scala
class Animal
class Cat extends Animal
class Dog extends Animal
```
If Cat extends Animal, does a List[Cat] extends a List[Animal]

Answers:
```scala
// 1. Yes - List[Cat] extends List[Animal] - covariance
class CovariantList[+Animal]
val catList: CovariantList[Cat] = SomeList[Cat]

// Now, can we put in a Dog in this?
// catList.add(new Dog) ???

// 2. No - invariance
class InvariantList[A]
// val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] will not work

// 3. hell no - contravariant
class ContraVariantList[-A]
val contravariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

class Trainer[-A]
val trainer: Trainer[Cat] = new Trainer[Animal]
```

### Bounded Types
Certain types - sub/super classes
```scala
// class cage accepts only type parameters A which are subtypes of Animal
class Cage[A <: Animal] (val animal: A)

val c: Cage[Dog] = new Cage(new Dog)
```

To address the question:
```scala
class CovariantList[+Animal]
val catList: CovariantList[Cat] = SomeList[Cat]
// Now, can we put in a Dog in this?
// catList.add(new Dog) ???
```
Bounded types solve this kind of problem:
```scala
// if to a List[Cat] you add new Dog - this will turn the List into a List[Animal]
class MyList[+A] {
  // if to a List[A] I add a B which is a supertype of A
  // then this List will become a List[B]
  def add[B :> A] (e: B): MyList[B] = ???
}
// Answer - we return a List of the supertype of both - Animal
```