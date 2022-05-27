package com.idenchev.exercises.fp
package InheritanceComposition.classes

abstract class AbstractElement {

  def contents: Vector[String]

  def height: Int = contents.length

  def width: Int = {
    if (height == 0)
      0
    else
      contents(0).length
  }

  def above(other: AbstractElement): AbstractElement = {
    VectorElement(this.contents ++ other.contents)
  }

  def beside(other: AbstractElement): AbstractElement = {
    VectorElement(
      this.contents.zip(other.contents)
                   .map((c1, c2) => c1 + c2))
  }

  override def toString: String = contents.mkString("\n")
}

object AbstractElement {

  def element(contents: Vector[String]): AbstractElement = VectorElement(contents)
  def element(line: String): AbstractElement = LineElement(line)
}