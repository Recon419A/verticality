package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock


object Cuboid {
  private def apply(coordinate: Coordinate, block: SimpleBlock): Structure = {
    Structure((ORIGIN to coordinate).map(c => Voxel(c, block)).toSet)
  }

  def apply(size: Size, block: SimpleBlock = DEFAULT_BLOCK): Structure = {
    Cuboid(Coordinate(size), block)
  }
}
