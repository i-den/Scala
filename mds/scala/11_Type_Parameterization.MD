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