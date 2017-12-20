package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.{DEFAULT_MATERIAL, ORIGIN}
import net.morbz.minecraft.blocks.SimpleBlock

case class Cuboid(voxels: Set[Voxel]) extends Structure[Cuboid] {
  def apply(voxels: Set[Voxel]): Cuboid = {
    Cuboid(voxels)
  }
}

object Cuboid {
  def apply(maxCoordinate: Coordinate, block: SimpleBlock): Cuboid = {
    Cuboid((ORIGIN to maxCoordinate).map(c => Voxel(c, block)).toSet)
  }

  def apply(maxCoordinate: Coordinate): Cuboid = {
    Cuboid(maxCoordinate, DEFAULT_MATERIAL)
  }

  def apply(width: Int, height: Int, depth: Int, block: SimpleBlock): Cuboid = {
    Cuboid(Coordinate(width - 1, height - 1, depth - 1), block)
  }

  def apply(width: Int, height: Int, depth: Int): Cuboid = {
    Cuboid(width, height, depth, DEFAULT_MATERIAL)
  }

  def apply(width: Int, height: Int, block: SimpleBlock): Cuboid = {
    Cuboid(width, height, 1, block)
  }

  def apply(width: Int, height: Int): Cuboid = {
    Cuboid(width, height, 1)
  }
}
