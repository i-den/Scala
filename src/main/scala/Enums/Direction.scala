package com.idenchev.exercises.fp
package Enums

import Enums.Direction.{East, North, South, West}

enum Direction(val degrees: Int) {
  case North extends Direction(0)
  case East extends Direction(90)
  case South extends Direction(180)
  case West extends Direction(270)

  def invert(): Direction = {
    this match
      case North => South
      case East => West
      case South => North
      case West => East
  }
}
