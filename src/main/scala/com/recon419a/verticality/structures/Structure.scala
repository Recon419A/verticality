package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import net.morbz.minecraft.world.World

case class Structure(voxels: Set[Voxel] = Set.empty[Voxel]) {
  def +(coordinate: Coordinate): Structure = {
    Structure(voxels.map(v => v + coordinate))
  }

  def +(other: Structure): Structure = {
    Structure((this - other).voxels ++ other.voxels)
  }

  def ++(that: Iterable[Structure]): Structure = {
    that.foldLeft(this)((s1: Structure, s2: Structure) => s1 + s2)
  }

  def rotateCounterClockwise: Structure = {
    Structure(voxels.map(v => {
      val x = v.coordinate.z
      val z = 10 - v.coordinate.x
      v.copy(coordinate = Coordinate(x, v.coordinate.y, z))
    }))
  }

  def rotateFlip: Structure = {
    rotateCounterClockwise.rotateCounterClockwise
  }

  def rotateClockwise: Structure = {
    rotateFlip.rotateCounterClockwise
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

  def minCoordinate: Coordinate = {
    val xMin = voxels.map(_.coordinate.x).min
    val yMin = voxels.map(_.coordinate.y).min
    val zMin = voxels.map(_.coordinate.z).min
    Coordinate(xMin, yMin, zMin)
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
