package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate}

object AtriumRingLocations {
  def apply(radius: Int): IndexedSeq[Coordinate] = {
    for (x <- -radius to radius;
         z <- -radius to radius
         if (Math.abs(x) == radius || Math.abs(z) == radius) && x % 2 == 0 && z % 2 == 0) yield GridCoordinate(x, 0, z)
  }
}
