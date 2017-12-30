package com.recon419a.verticality.util

object GridSize {
  def apply(width: Int, height: Int, depth: Int = 1): Size = {
    Size(
      GRID_SIZE.width * width,
      GRID_SIZE.height * height,
      GRID_SIZE.depth * depth
    ) + Size(1, 1)
  }
}
