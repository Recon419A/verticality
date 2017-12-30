package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Room {
  def apply(stories: Int = 1): Structure = {
    val size = Size(11, 4 * stories + 1, 11)
    val hollowCenter = Cuboid(size - Size(2, 2, 2), SimpleBlock.AIR) + Coordinate(1, 1, 1)
    Cuboid(size) + hollowCenter
  }
}
