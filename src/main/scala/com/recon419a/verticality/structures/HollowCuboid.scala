package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, DEFAULT_MATERIAL, ORIGIN, Structure, Voxel}

class HollowCuboid(val maxCoordinate: Coordinate, val offset: Coordinate) extends Structure {
  def voxel: Coordinate => Option[Voxel] = c => {
    /*
    Produce a voxel if it's at the minimum or maximum of any dimension, and within the volume.
     */
    if (atMinMaxOfOneDimension(c) && (ORIGIN to maxCoordinate).contains(c)) {
      Some(Voxel(c, DEFAULT_MATERIAL))
    }
    else None
  }

  private def atMinMaxOfOneDimension(c: Coordinate) = {
    List(0, maxCoordinate.x).contains(c.x) ||
      List(0, maxCoordinate.y).contains(c.y) ||
      List(0, maxCoordinate.z).contains(c.z)
  }
}

object HollowCuboid {
  def apply(maxCoordinate: Coordinate, offset: Coordinate): HollowCuboid = {
    new HollowCuboid(maxCoordinate, offset)
  }
}