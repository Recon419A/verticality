package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Grid {
  def apply(coordinate: Coordinate, spacing: Coordinate, block: SimpleBlock): Structure = {
    Structure(Cuboid(coordinate, block).voxels.filter(v => onGrid(spacing, v)))
  }

  def apply(width: Int, height: Int, depth: Int, spacing: Coordinate, block: SimpleBlock): Structure = {
    Grid(Coordinate(width - 1, height - 1, depth - 1), spacing, block)
  }

  def apply(width: Int, height: Int, depth: Int, spacing: Coordinate): Structure = {
    Grid(width, height, depth, spacing, DEFAULT_MATERIAL)
  }

  private def onGrid(spacing: Coordinate, v: Voxel) = {
    v.coordinate.x % spacing.x == 0 && v.coordinate.y % spacing.y == 0 &&
      v.coordinate.z % spacing.z == 0
  }
}
