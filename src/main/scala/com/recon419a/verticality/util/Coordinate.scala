package com.recon419a.verticality.util

case class Coordinate(x: Int, y: Int, z: Int = 0) {
  def +(c: Coordinate): Coordinate = {
    Coordinate(x + c.x, y + c.y, z + c.z)
  }

  def -(c: Coordinate): Coordinate = {
    Coordinate(x - c.x, y - c.y, z - c.z)
  }

  def /(i: Int): Coordinate = {
    Coordinate(x / i, y / i, z / i)
  }

  def <=(c: Coordinate): Boolean = {
    x <= c.x && y <= c.y && z <= c.z
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