package com.recon419a.verticality.util

case class Coordinate(x: Int, y: Int, z: Int = 0) {
  def +(that: Coordinate): Coordinate = {
    Coordinate(x + that.x, y + that.y, z + that.z)
  }

  def -(that: Coordinate): Coordinate = {
    Coordinate(x - that.x, y - that.y, z - that.z)
  }

  def /(that: Int): Coordinate = {
    Coordinate(x / that, y / that, z / that)
  }

  def <<=(that: Coordinate): Boolean = {
    x <= that.x && y <= that.y && z <= that.z
  }

  def to(end: Coordinate): List[Coordinate] = {
    for (x <- x to end.x;
         y <- y to end.y;
         z <- z to end.z)
      yield Coordinate(x, y, z)
  }.toList
}

object Coordinate {
  def apply(size: Size): Coordinate = {
    Coordinate(size.width - 1, size.height - 1, size.depth - 1)
  }
}