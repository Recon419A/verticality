package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock

case class HollowCuboid(maxCoordinate: Coordinate) extends Structure {
  override def blocks: Coordinate => SimpleBlock = {
    coordinate => {

    }
  }
}
