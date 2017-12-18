package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, ORIGIN, DEFAULT_MATERIAL, Structure, Voxel}

class FilledCuboid(val maxCoordinate: Coordinate, val offset: Coordinate) extends Structure {
  override def voxel: Coordinate => Option[Voxel] = c => {
    if ((ORIGIN to maxCoordinate).contains(c)) {
      Some(Voxel(c, DEFAULT_MATERIAL))
    } else None
  }
}

object FilledCuboid {
  def apply(maxCoordinate: Coordinate, offset: Coordinate): FilledCuboid = {
    new FilledCuboid(maxCoordinate, offset)
  }
}