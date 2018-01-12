package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel

object StairsClockwise {
  def apply(): Structure = {
    Structure(
      Set(Voxel(3, 1, 9), Voxel(2, 2, 9), Voxel(1, 2, 9), Voxel(1, 3, 8), Voxel(1, 4, 7))
    )
  }
}
