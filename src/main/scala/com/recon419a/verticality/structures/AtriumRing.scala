package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate}

object AtriumRing {
  def apply(radius: Int): IndexedSeq[Structure] = {
    val grid = for (x <- -4 * radius to 4 * radius;
                    z <- -4 * radius to 4 * radius)
      yield Coordinate(x, 0, z)
    val openAtriums = grid.filter(isOpenAtriumLocation(_, radius)).map(c =>
      OpenAtrium() + GridCoordinate(c.x, c.y, c.z))
    val closedAtriums = grid.filter(isClosedAtriumLocation(_, radius)).map(c =>
      ClosedAtrium() + GridCoordinate(c.x, c.y, c.z))
    closedAtriums ++ openAtriums
  }

  def isClosedAtriumLocation(c: Coordinate, radius: Int): Boolean = {
    isMixedDiamond(radius) && c.x % 4 == 0 && c.z % 4 == 0
  }

  def isOpenAtriumLocation(c: Coordinate, radius: Int): Boolean = {
    (isOpenOnlyDiamond(radius) && onDiamond(c, radius) && c.x % 2 == 0 && c.z % 2 == 0) ||
      (isMixedDiamond(radius) && onDiamond(c, radius) && c.x % 4 == 2 && c.z % 4 == 2)
  }

  def isOpenOnlyDiamond(radius: Int) = {
    radius % 2 == 1
  }

  def isMixedDiamond(radius: Int) = {
    radius % 2 == 0
  }

  def onDiamond(c: Coordinate, radius: Int): Boolean = {
    Math.abs(c.z - c.x) == 4 * radius || Math.abs(c.z + c.x) == 4 * radius
  }
}
