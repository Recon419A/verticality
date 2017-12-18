package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, DEFAULT_MATERIAL, Structure, Voxel}

case class FilledCuboid(maxCoordinate: Coordinate, offset: Coordinate) extends Structure {
  override def voxel: Coordinate => Option[Voxel] = c => Some(Voxel(c, DEFAULT_MATERIAL))
}