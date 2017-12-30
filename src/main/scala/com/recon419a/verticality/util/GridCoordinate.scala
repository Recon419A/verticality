package com.recon419a.verticality.util

object GridCoordinate {
  def apply(x: Int, y: Int, z: Int = 0): Coordinate = {
    Coordinate(x * GRID_SIZE.width, y * GRID_SIZE.height, z * GRID_SIZE.depth)
  }
}
