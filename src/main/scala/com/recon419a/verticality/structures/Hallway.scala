package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel

case class Hallway(voxels: Set[Voxel]) extends Structure[Hallway] {
  def apply(voxels: Set[Voxel]): Hallway = {
    Hallway(voxels)
  }
}