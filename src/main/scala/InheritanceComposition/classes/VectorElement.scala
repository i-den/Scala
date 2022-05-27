package com.idenchev.exercises.fp
package InheritanceComposition.classes

class VectorElement(c: Vector[String]) extends AbstractElement {
  override def contents: Vector[String] = c

}
