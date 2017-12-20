package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}

object Hallway {
  def apply(width: Int, height: Int, depth: Int): Unit = {
    val footprint = Cuboid(width, height, depth)
    val borehole = Cuboid(width - 2, height - 2, depth) + Coordinate(1, 1)
    footprint - borehole
  }
}