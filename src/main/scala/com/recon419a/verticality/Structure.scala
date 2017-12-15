package com.recon419a.verticality

import net.morbz.minecraft.world.World

trait Structure {
  val voxels: List[Voxel]

  def renderTo(world: World, offset: Coordinate = Coordinate(0, 0, 0)): Unit = {
    val translatedVoxels = voxels.map(v => Voxel(v.coordinate + offset, v.block))
    translatedVoxels.foreach(voxel => voxel.renderTo(world))
  }
}
