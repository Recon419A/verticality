package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}

object Bridges extends MultiStoryAtrium {
  override val atrium: Atrium = BridgeAtrium

  override def apply(wingFlags: Seq[Seq[Boolean]]): Structure = {
    super.apply(wingFlags)
  }

  //  def bridgeFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
  //
  //  }

  object BridgeAtrium extends Atrium {
    override val wingStructure: Structure = Cuboid(Size(3, 11)) + Coordinate(4, 0, -10)
    override val centerStructure: Structure = Structure()
  }

}
