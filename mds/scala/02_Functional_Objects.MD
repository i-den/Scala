#### Ctor
```scala
class Rational(numerator: Int, denominator: Int) {
  println(s"Created $numerator / $denominator")
}

val rational = new Rational(1, 2)
// prints Created 1 / 2
```

Can omit the 'new' keyword. Universal Apply Method
```scala
val rational = Rational(1, 2)
```

#### Adding methods
```scala
class Rational(n: Int, d: Int) {

  require(d != 0, "Rational Numbers don't accept 0 as a denominator")
  val numerator: Int = n
  val denominator: Int = d

  def add(other: Rational) : Rational = {
    Rational(
      (numerator * other.denominator) + (other.numerator * denominator),
      (denominator * other.denominator))
  }

  def lessThan(other: Rational): Boolean = {
    (numerator * other.denominator) < (other.numerator * denominator)
  }

  def max(other: Rational): Rational = {
    if (this.lessThan(other))
      other
    else
      this
  }

  override def toString: String = s"$numerator/$denominator"

}
```

#### Auxiliary constructs
Auxiliary constructors in Scala start with def this(...)

In Scala, every auxiliary constructor must invoke another constructor of the same class as its first action

The net effect of this rule is that every constructor invocation in Scala will end up eventually calling the primary constructor of the class.

The primary constructor is thus the single point of entry of a class.
```scala
class Rational(n: Int, d: Int) {
  // Auxiliary constructor
  def this(n: Int) = this(n, 1)
  // Auxiliary constructor
}
```

#### Adding private methods
```scala
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }
```

#### Overriding
```scala
class Rational(n: Int, d: Int) {

  // Constructor like
  require(d != 0, "Rational Numbers don't accept 0 as a denominator")
  private val g = gcd(n, d)
  val numerator: Int = n / g
  val denominator: Int = d / g
  // Constructor like

  // Auxiliary constructor
  def this(n: Int) = this(n, 1)
  // Auxiliary constructor

  // Methods
  def +(other: Rational): Rational = add(other)
  def +(n: Int): Rational = add(n)
  def -(other: Rational): Rational = subtract(other)
  def -(n: Int): Rational = subtract(n)
  def * (other: Rational): Rational = multiply(other)
  def * (n: Int): Rational = multiply(n)
  def / (other: Rational): Rational = divide(other)
  def / (n: Int): Rational = divide(n)

  def add(other: Rational): Rational = {
    Rational(
      (numerator * other.denominator) + (other.numerator * denominator),
      (denominator * other.denominator))
  }

  def add(n: Int): Rational = {
    Rational((numerator + n), (denominator))
  }

  def subtract(other: Rational): Rational = {
    Rational(
      (numerator * other.denominator) - (other.numerator * denominator),
      (denominator * other.denominator))
  }

  def subtract(n: Int): Rational = {
    Rational((numerator - (n * denominator)), denominator)
  }

  def multiply(other: Rational): Rational = {
    Rational(
      (numerator * other.numerator),
      (denominator * other.denominator))
  }

  def multiply(n: Int): Rational = {
    Rational((numerator * n), denominator)
  }

  def divide(other: Rational): Rational = {
    Rational(
      (numerator * other.denominator),
      (denominator * other.numerator))
  }

  def divide(n: Int): Rational = {
    Rational(numerator, (denominator * n))
  }

  def lessThan(other: Rational): Boolean = {
    (numerator * other.denominator) < (other.numerator * denominator)
  }

  def max(other: Rational): Rational = {
    if (this.lessThan(other))
      other
    else
      this
  }

  // Overwrite methods
  override def toString: String = {
    if(denominator == 1)
      s"$numerator"
    else
      s"$numerator/$denominator"
  }

  // Helper Methods
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }
}
```


