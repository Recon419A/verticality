package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}

object Bridges extends MultiStoryAtrium {
  override val atrium: Atrium = BridgeAtrium

  override def apply(wingFlags: Seq[WingFlags], existingStructure: Structure = Structure()): Structure = {
    super.apply(bridgeFlags(wingFlags), existingStructure)
  }

  def bridgeFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    wingFlags.map(bridgeFlags)
  }

  def bridgeFlags(wingFlags: WingFlags): WingFlags = {
    WingFlags(north = wingFlags.north && wingFlags.south,
      east = wingFlags.east && wingFlags.west)
  }

  object BridgeAtrium extends Atrium {
    override val wingStructure: Structure = Cuboid(Size(3, 1, 11)) + Coordinate(4, 0, -10)
    override val centerStructure: Structure = Structure()
  }

}
