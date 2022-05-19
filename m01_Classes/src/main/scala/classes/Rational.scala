package classes

import scala.annotation.targetName

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
