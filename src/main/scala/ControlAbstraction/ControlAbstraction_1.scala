package com.idenchev.exercises.fp
package ControlAbstraction

import java.io.File

object ControlAbstraction_1 {

  private def localFiles: Array[File] = new File(".").listFiles()

  def filesMatching(matcher: String => Boolean): Array[File] = {
    for (file <- localFiles if matcher(file.getName))
      yield file
  }

  def filesEnding(q: String): Array[File] = {
    filesMatching(fileName => fileName.endsWith(q))
  }

  def filesContaining(q: String): Array[File] = {
    filesMatching(fileName => fileName.contains(q))
  }

  def filesRegex(q: String): Array[File] = {
    filesMatching(fileName => fileName.matches(q))
  }

}
