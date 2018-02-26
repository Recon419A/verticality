package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

object StairsClockwiseAtrium extends Atrium {
  override val wingStructure: Structure = StairsClockwise() + GridCoordinate(0, 0, -1)
  override val centerStructure: Structure = Structure()
}
