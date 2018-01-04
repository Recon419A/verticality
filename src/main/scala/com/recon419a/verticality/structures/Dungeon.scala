package com.recon419a.verticality.structures

object Dungeon {
  def apply(): Structure = {
    //    ClosedAtrium() ++ AtriumRing(2) ++ AtriumRing(1)
    //    MultiStoryClosedAtrium(2) + (MultiStoryClosedAtrium(2) + GridCoordinate(1, 0, 1))
    MultiStoryClosedAtrium(4)
  }
}
