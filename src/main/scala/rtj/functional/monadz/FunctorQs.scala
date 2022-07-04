package com.idenchev.exercises.fp
package rtj.functional.monadz

import scala.util.Try

object FunctorQs extends App {
  val anIncrementedList: List[Int] = List(1, 2, 3).map(_ + 1)

  // This map transformation can be applied to other data structures as well

  // Option
  val anOption: Option[Int] = Some(42)
  // Try
  val aTry: Try[Int] = Try(42)

  // Functors

  // something that multiples a list, option and try by 10
  def forList(list: List[Int]): List[Int] = list.map(_ * 10)
  def forOption(option: Option[Int]): Option[Int] = option.map(_ * 10)
  def forTry(tryy: Try[Int]): Try[Int] = tryy.map(_ * 10)
  // this seems identical, we don't need to repeat
  // the map concept is transferable
  // lets define a typed Trait

  // C is the type of mappable obj
  trait Functor[C[_]] {
    // container like List[Int]
    // function transforming from A => B
    // returning container of the new values
    def map[A, B](container: C[A])(fn: A => B): C[B]
  }

  trait Tree[+T]
  object Tree {
    def leaf[T](value: T): Tree[T] = Leaf(value)
    def branch[T](value: T, left: Tree[T], right: Tree[T]): Tree[T] = Branch(value, left, right)
  }

  case class Leaf[+T](value: T) extends Tree[T]

  case class Branch[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

  // define functor
  given treeFunctor: Functor[Tree] with {
    override def map[A, B](container: Tree[A])(fn: A => B): Tree[B] = container match {
      case Leaf(value) => Leaf(fn(value))
      case Branch(value, left, right) => Branch(fn(value), map(left)(fn), map(right)(fn))
    }
  }

  def do10x[C[_]](container: C[Int])(using functor: Functor[C]): C[Int] = functor.map(container)(_ * 10)

  val tree = Tree.branch(1,
    Tree.branch(2,
      Tree.leaf(3),
      Tree.leaf(4)),
  Tree.leaf(5))

  println(do10x(tree))

  // Makes a data structure mappable
}
