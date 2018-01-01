package com.recon419a.verticality.structures

object Dungeon {
  def apply(): Structure = {
    ClosedAtrium() ++ AtriumRing(1) ++ AtriumRing(2)
  }
}
