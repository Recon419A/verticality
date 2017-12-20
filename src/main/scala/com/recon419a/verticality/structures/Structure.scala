package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}

case class Structure(voxels: Set[Voxel]) {
  def +(coordinate: Coordinate): Structure = {
    Structure(voxels.map(v => v + coordinate))
  }

  def -(other: Structure): Structure = {
    Structure(voxels.filterNot(voxel => other.voxels.map(_.coordinate) contains voxel.coordinate))
  }

  def voxel(coordinate: Coordinate): Option[Voxel] = {
    voxels.find(_.coordinate == coordinate)
  }

  def voxel(x: Int, y: Int, z: Int): Option[Voxel] = {
    voxel(Coordinate(x, y, z))
  }
}
