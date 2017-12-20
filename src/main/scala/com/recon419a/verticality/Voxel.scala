package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World

case class Voxel(coordinate: Coordinate, block: SimpleBlock) {
  def renderTo(world: World): Unit = {
    world.setBlock(coordinate.x, coordinate.y, coordinate.z, block)
  }

  def translate(c: Coordinate): Voxel = {
    Voxel(coordinate + c, block)
  }

  def translate(x: Int, y: Int, z: Int): Voxel = {
    translate(Coordinate(x, y, z))
  }

  def translate(x: Int, y: Int): Voxel = {
    translate(Coordinate(x ,y))
  }
}

object Voxel {
  def apply(x: Int, y: Int, z: Int, block: SimpleBlock): Voxel = {
    Voxel(Coordinate(x, y, z), block)
  }

  def apply(x: Int, y: Int, block: SimpleBlock): Voxel = {
    apply(x, y, 0, block)
  }

  def apply(x: Int, y: Int, z: Int): Voxel = {
    apply(x, y, z, DEFAULT_MATERIAL)
  }

  def apply(x: Int, y: Int): Voxel = {
    apply(x, y, 0)
  }
}
