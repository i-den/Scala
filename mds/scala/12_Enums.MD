#### Enums

```scala
enum Direction(val degrees: Int) {
  case North extends Direction(0)
  case East extends Direction(90)
  case South extends Direction(180)
  case West extends Direction(270)

  def invert(dir: Direction): Direction = {
    this match
    case North => South
    case East => West
    case South => North
    case West => East
  }
}
```

#### Algebraic Data Types (ADTs)
```scala
enum Eastwood[+G, +B] {
  case Good(g: G)
  case Bad(b: B)
  case Ugly(ex: Throwable)

  def map[G2](f: G => G2): Eastwood[G2, B] = {
    this match
      case Good(g) => Good(f(g))
      case Bad(b) => Bad(b)
      case Ugly(ex) => Ugly(ex)
  }
}
```
boils down to
```scala
// Generated sealed trait (the "enum type")
sealed trait Eastwood[+G, +B]

object Eastwood: // Generated companion object
// Generated case classes
  case class Good[+G, +B](g: G) extends Eastwood[G, B]
  case class Bad[+G, +B](b: B) extends Eastwood[G, B]
  case class Ugly[+G, +B](ex: Throwable) extends Eastwood[G, B]
```
```scala
val eastwood: Good[Int, Nothing] = Good(41)
println(eastwood.map(n => n + 1)) // Good(42)
```

Algebraic - possible # of values