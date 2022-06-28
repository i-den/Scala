Kind of type that has fundamental operations for it
```scala
trait MonadTemplate[A] {
  // Unit (apply in Scala or Pure in other langs)
  // constructs a Monad out of a value / values
  def unit(value: A): MonadTemplate[A]
  // flatMap / Bind
  // transforms a monad of A to monad of B
  def flatMap[B](f: A => MonadTemplate[B]): MonadTemplate[B]
}
```

### 3 Monad laws
#### Left Identity
```scala
// if you build a monad with X and you flatMap it with a fn it should give you f(x)
unit(x).flatMap(fn) == f(x)
```
#### Right Identity
```scala
aMonadInstance.flatMap(unit) == aMonadInstance
```

#### Associativity
```scala
m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g)
```

#### In Option
```scala
// left
Option(x).flatMap(f) = f(x)
Some(x).flatMap(f) = f(x)
// right
opt.flatMap(x => Option(x)) == opt
Some(v).flatMap(x => Option(x)) == Option(v) == Some(v)

// associativity
o.flatMap(f).flatMap(g) == o.flatMap(x => f(x).flatMap(g))
Some(v).flatMap(f).flatMap(g) == f(v).flatMap(g)
Some(v).flatMap(x => f(x).flatMap(g)) == f(v).flatMap(g)
```
