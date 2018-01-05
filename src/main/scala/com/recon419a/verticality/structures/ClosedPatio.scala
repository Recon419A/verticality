package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import net.morbz.minecraft.blocks.SimpleBlock

object ClosedPatio {
  def apply(): Structure = {
    val fenceVoxels = Igloo(SimpleBlock.ACACIA_FENCE).voxels.filter(_.coordinate.y == 1).filter(_.coordinate.z != 0)
    val door = Cuboid(Size(1, 2), SimpleBlock.AIR) + Coordinate(5, 1)
    val step = Cuboid(Size(3, 1)) + Coordinate(4, 0, -1)
    Structure(fenceVoxels) + door + step
  }
}
