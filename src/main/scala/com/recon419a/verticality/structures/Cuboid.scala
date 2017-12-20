package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.{DEFAULT_MATERIAL, ORIGIN}
import net.morbz.minecraft.blocks.SimpleBlock


object Cuboid {
  def apply(maxCoordinate: Coordinate, block: SimpleBlock): Structure = {
    Structure((ORIGIN to maxCoordinate).map(c => Voxel(c, block)).toSet)
  }

  def apply(maxCoordinate: Coordinate): Structure = {
    Cuboid(maxCoordinate, DEFAULT_MATERIAL)
  }

  def apply(width: Int, height: Int, depth: Int, block: SimpleBlock): Structure = {
    Cuboid(Coordinate(width - 1, height - 1, depth - 1), block)
  }

  def apply(width: Int, height: Int, depth: Int): Structure = {
    Cuboid(width, height, depth, DEFAULT_MATERIAL)
  }

  def apply(width: Int, height: Int, block: SimpleBlock): Structure = {
    Cuboid(width, height, 1, block)
  }

  def apply(width: Int, height: Int): Structure = {
    Cuboid(width, height, 1)
  }
}
