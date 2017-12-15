package com.recon419a.verticality

import net.morbz.minecraft.world.World

trait Structure {
  def voxels: Coordinate => Option[Voxel]

  val maxCoordinate: Coordinate

  def renderTo(world: World, offset: Coordinate = ORIGIN): Unit = {
    val coordinates = Coordinate(0, 0, 0) to maxCoordinate
    val offsetVoxels = coordinates.map(voxels).map(o => o.map(v => v.offset(offset)))
    offsetVoxels.foreach(v => renderIfExtant(v, world))
  }

  private def renderIfExtant(v: Option[Voxel], world: World): Unit = {
    v.foreach(_.renderTo(world))
  }

  def contains(c: Coordinate, offset: Coordinate = ORIGIN): Boolean = {
    offset <= c && c <= (maxCoordinate + offset)
  }
}
