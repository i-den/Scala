package classes

import scala.collection.mutable

class ChecksumAccumulator:
  private var sum = 0

  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1

object ChecksumAccumulator:
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if cache.contains(s) then
      cache(s)
    else
      val acc = new ChecksumAccumulator // An Instance of the Class,
                                        // not the Singleton obj that is represented by the Object

      for (c <- s) do
        acc.add((c >> 8).toByte)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
  }



