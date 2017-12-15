package com.recon419a.verticality

case class FilledCuboid(maxCoordinate: Coordinate) extends Structure {
  override def voxels: Coordinate => Option[Voxel] = c => Some(Voxel(c, DEFAULT_MATERIAL))
}