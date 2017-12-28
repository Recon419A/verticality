package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Grid {
  def apply(size: Size, spacing: Coordinate, block: SimpleBlock = DEFAULT_MATERIAL): Structure = {
    Structure(Cuboid(size, block).voxels.filter(v => onGrid(spacing, v)))
  }

  private def onGrid(spacing: Coordinate, v: Voxel) = {
    v.coordinate.x % spacing.x == 0 && v.coordinate.y % spacing.y == 0 &&
      v.coordinate.z % spacing.z == 0
  }
}
