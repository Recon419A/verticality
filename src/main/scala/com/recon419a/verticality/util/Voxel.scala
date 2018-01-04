package com.recon419a.verticality.util

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World

case class Voxel(coordinate: Coordinate, block: SimpleBlock = DEFAULT_BLOCK) {
  def renderTo(world: World): Unit = {
    world.setBlock(coordinate.x, coordinate.y, coordinate.z, block)
  }

  def +(c: Coordinate): Voxel = {
    Voxel(coordinate + c, block)
  }
}

object Voxel {
  def apply(x: Int, y: Int, z: Int, block: SimpleBlock): Voxel = {
    Voxel(Coordinate(x, y, z), block)
  }

  def apply(x: Int, y: Int, block: SimpleBlock): Voxel = {
    Voxel(Coordinate(x, y), block)
  }

  def apply(x: Int, y: Int, z: Int): Voxel = {
    Voxel(Coordinate(x, y, z))
  }

  def apply(x: Int, y: Int): Voxel = {
    Voxel(Coordinate(x, y))
  }
}
