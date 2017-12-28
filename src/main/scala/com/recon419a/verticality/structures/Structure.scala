package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Rotation.Rotation
import com.recon419a.verticality.util.{Coordinate, Rotation, Voxel}
import net.morbz.minecraft.world.World

case class Structure(voxels: Set[Voxel]) {
  def +(coordinate: Coordinate): Structure = {
    Structure(voxels.map(v => v + coordinate))
  }

  def +(other: Structure): Structure = {
    Structure((this - other).voxels ++ other.voxels)
  }


  private def rotateCounterClockwise = {
    Structure(voxels.map(v => {
      val x = v.coordinate.z
      val z = maxCoordinate.x - v.coordinate.x
      v.copy(coordinate = Coordinate(x, v.coordinate.y, z))
    }))
  }

  def -(other: Structure): Structure = {
    Structure(voxels.filterNot(voxel => other.voxels.map(_.coordinate) contains voxel.coordinate))
  }

  def maxCoordinate: Coordinate = {
    val xMax = voxels.map(_.coordinate.x).max
    val yMax = voxels.map(_.coordinate.y).max
    val zMax = voxels.map(_.coordinate.z).max
    Coordinate(xMax, yMax, zMax)
  }

  def voxel(coordinate: Coordinate): Option[Voxel] = {
    voxels.find(_.coordinate == coordinate)
  }

  def voxel(x: Int, y: Int, z: Int): Option[Voxel] = {
    voxel(Coordinate(x, y, z))
  }

  def renderTo(world: World): Unit = {
    voxels.foreach(_.renderTo(world))
  }
}
