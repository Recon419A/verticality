package com.recon419a.verticality

import net.morbz.minecraft.world.World

trait Structure {
  def blocks: Coordinate => Option[Voxel]

  def maxCoordinate: Coordinate

  def renderTo(world: World, offset: Coordinate = Coordinate(0, 0, 0)): Unit = {
    val coordinates = offset to maxCoordinate + offset
    coordinates.map(blocks).foreach(v => renderIfExtant(v, world))
  }

  def renderIfExtant(v: Option[Voxel], world: World): Unit = {
    v.foreach(_.renderTo(world))
  }
}
