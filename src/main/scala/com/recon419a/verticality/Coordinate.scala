package com.recon419a.verticality

case class Coordinate(x: Int, y: Int, z: Int) {
  def +(c: Coordinate): Coordinate = {
    Coordinate(this.x + c.x, this.y + c.y, this.z + c.z)
  }

  def -(c: Coordinate): Coordinate = {
    Coordinate(this.x - c.x, this.y - c.y, this.z - c.z)
  }

  def to(end: Coordinate): List[Coordinate] = {
    for (x <- 0 to end.x;
         y <- 0 to end.y;
         z <- 0 to end.z)
      yield Coordinate(x, y, z)
  }.toList
}