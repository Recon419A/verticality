package com.recon419a.verticality

case class FilledCuboid(maxCoordinate: Coordinate, offset: Coordinate) extends Structure {
  override def voxel: Coordinate => Option[Voxel] = c => Some(Voxel(c, DEFAULT_MATERIAL))
}