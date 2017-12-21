package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Room {
  def apply(size: Size, block: SimpleBlock = DEFAULT_MATERIAL): Structure = {
    assert(size >>= Size(3, 3, 3))
    Cuboid(size, block) - (Cuboid(size - Size(2, 2, 2)) + Coordinate(1, 1, 1))
  }
}
