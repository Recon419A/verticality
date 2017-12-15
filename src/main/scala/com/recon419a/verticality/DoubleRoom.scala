package com.recon419a.verticality

object DoubleRoom extends Structure {
  val room1 = BasicRoom
  val room2 = BasicRoom{offset = }
  val offset = Coordinate()
  override def voxels: Coordinate => Option[Voxel] = ???

  override val maxCoordinate: Coordinate = _
}
