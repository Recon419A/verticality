package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate}

object GridCoordinateRing {
  def apply(radius: Int): IndexedSeq[Coordinate] = {
    for (x <- -radius to radius;
         z <- -radius to radius
         if Math.abs(x) == radius || Math.abs(z) == radius) yield GridCoordinate(x, 0, z)
  }
}
