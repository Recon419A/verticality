package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}

trait Structure[T <: Structure[T]] {
  def voxels: Set[Voxel]

  def apply(voxels: Set[Voxel]): T

  def +(coordinate: Coordinate): T = {
    apply(voxels.map(v => v + coordinate))
  }
}
