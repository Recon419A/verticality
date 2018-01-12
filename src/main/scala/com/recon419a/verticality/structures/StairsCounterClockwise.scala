package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel

object StairsCounterClockwise {
  def apply(): Structure = {
    Structure(
      Set(Voxel(7, 1, 9), Voxel(8, 2, 9), Voxel(9, 2, 9), Voxel(9, 3, 8), Voxel(9, 4, 7))
    )
  }
}