package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock

object Hallway {
  def apply(block: SimpleBlock = DEFAULT_BLOCK): Structure = {
    val borehole = Cuboid(Size(3, 3, 11), SimpleBlock.AIR) + Coordinate(1, 1)
    val lighting = Structure(Set(Voxel(2, 4, 3, SimpleBlock.GLOWSTONE), Voxel(2, 4, 7, SimpleBlock.GLOWSTONE)))
    (Cuboid(Size(5, 5, 11), block) + borehole + lighting) + Coordinate(3, 0)
  }
}