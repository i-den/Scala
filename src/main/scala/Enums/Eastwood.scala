package com.idenchev.exercises.fp
package Enums

import Enums.Eastwood.{Bad, Good, Ugly}

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
