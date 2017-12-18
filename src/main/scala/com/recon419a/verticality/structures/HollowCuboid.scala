package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, DEFAULT_MATERIAL, Structure, Voxel}

class HollowCuboid(override val maxCoordinate: Coordinate, override val offset: Coordinate) extends Structure {
  override def voxel: Coordinate => Option[Voxel] = {
    c => {
      if (List(0, maxCoordinate.x).contains(c.x) ||
        List(0, maxCoordinate.y).contains(c.y) ||
        List(0, maxCoordinate.z).contains(c.z)) {
        Some(Voxel(c, DEFAULT_MATERIAL))
      }
      else {
        None
      }
    }
  }
}
