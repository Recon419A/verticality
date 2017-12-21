package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size, Voxel}

object Hallway {
  def apply(size: Size): Unit = {

  }

  def apply(width: Int, height: Int, depth: Int): Structure = {
    assert(width >= 3 && height >= 3, "Hallways must be at least 3x3 to have a meaningful interior.")
    assert(depth >=1, "Hallways must have a positive depth.")
    val footprint = Cuboid(width, height, depth)
    val borehole = Cuboid(width - 2, height - 2, depth) + Coordinate(1, 1)
    footprint - borehole
  }
}