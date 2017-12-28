package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import com.recon419a.verticality.util.Constants.{DEFAULT_MATERIAL, ORIGIN}
import net.morbz.minecraft.blocks.SimpleBlock


object Cuboid {
  private def apply(coordinate: Coordinate, block: SimpleBlock): Structure = {
    Structure((ORIGIN to coordinate).map(c => Voxel(c, block)).toSet)
  }

  def apply(size: Size, block: SimpleBlock = DEFAULT_MATERIAL): Structure = {
    Cuboid(Coordinate(size), block)
  }
}
