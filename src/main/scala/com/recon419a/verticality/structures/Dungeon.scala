package com.recon419a.verticality.structures

object Dungeon {
  def apply(): Structure = {
    val center = ClosedAtrium()
    val ring1 = GridCoordinateRing(2).map(OpenAtrium() + _)
    val ring2 = GridCoordinateRing(4).map(ClosedAtrium() + _)
    center ++ ring2 ++ ring1
  }
}
