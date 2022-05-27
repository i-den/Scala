package com.idenchev.exercises.fp
package InheritanceComposition.classes

class LineElement(s: String) extends VectorElement(Vector(s)) {
  override def height: Int = 1
  override def width: Int = s.length
}
