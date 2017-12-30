package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock

object Room {
  def apply(stories: Int = 1): Structure = {
    val size = Size(11, 4 * stories + 1, 11)
    val hollowCenter = Cuboid(size - Size(2, 2, 2), SimpleBlock.AIR) + Coordinate(1, 1, 1)
    val lighting = Structure(Set(Voxel(2, 4, 2, SimpleBlock.GLOWSTONE), Voxel(2, 4, 8, SimpleBlock.GLOWSTONE),
      Voxel(8, 4, 8, SimpleBlock.GLOWSTONE), Voxel(8, 4, 2, SimpleBlock.GLOWSTONE)))
    Cuboid(size) + hollowCenter + lighting
  }
}
