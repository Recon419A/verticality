package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Hallway {
  def apply(size: Size, block: SimpleBlock = DEFAULT_MATERIAL): Structure = {
    assert(size.width >= 3 && size.height >= 3, "Hallways must be at least 3x3 to have a meaningful interior.")
    assert(size.depth >=1, "Hallways must have a positive depth.")
    val innerSize = Size(size.width - 2, size.height - 2, size.depth)
    val borehole = Cuboid(innerSize) + Coordinate(1, 1)
    Cuboid(size) - borehole
  }
}