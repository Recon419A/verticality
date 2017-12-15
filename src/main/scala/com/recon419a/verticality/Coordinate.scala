package com.recon419a.verticality

case class Coordinate(x: Int, y: Int, z: Int) {
  def +(c: Coordinate): Coordinate = {
    Coordinate(x + c.x, y + c.y, z + c.z)
  }

  def -(c: Coordinate): Coordinate = {
    Coordinate(x - c.x, y - c.y, z - c.z)
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