```scala
trait Expr 
```
```scala
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
```

Case classes have some syntactic sugars
- adds factory method
```scala
val v = Var("x")
```
- adds a val prefix, maintained as field
```scala
val v = Var("x")
v.name // "x"
```
- adds default toString, hashCode, and equals
- adds copy

#### Pattern Matching usage
Uses unapply
```scala
def simplifyTop(expr: Expr): Expr = {
  expr match
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Num(0)) => e
    case BinOp("*", e, Num(1)) => e
    case _ => expr
}
```

Wildcards
```scala
expr match
  case BinOp(_, _, _) => s"$expr is a binary operation"
  case _ => "It's something else"
```

Anything 
```scala
def describe(x: Any): String = {
  x match
    case 5 => "Five"
    case true => "The Truth"
    case "hello" => "A Greeting"
    case _ => "Nothing of the above"
}
```

Lists
```scala
xs match
  case List(0, _, _) => "found it"
  case _ => ""
```
If you want to match against a sequence without specifying how long it
can be, you can specify _* as the last element of the pattern
```scala
xs match
  case List(0, _*) => "found it"
  case _ => ""
```

Typed Patterns
```scala
def generalSize(x: Any) =
  x match
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => 1
```

#### Sealed Classes
Must be in the same file
```scala
sealed trait SealedTrait {}

case class SealedClassA() extends SealedTrait {}
```