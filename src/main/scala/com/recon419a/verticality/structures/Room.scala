package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock

object Room {
  def apply(coordinate: Coordinate, block: SimpleBlock): Structure = {
    assert(Coordinate(2, 2, 2) <= coordinate)
    Cuboid(coordinate, block) - (Cuboid(coordinate - Coordinate(2, 2, 2)) + Coordinate(1, 1, 1))
  }

  def apply(coordinate: Coordinate): Structure = {
    Room(coordinate, DEFAULT_MATERIAL)
  }

  def apply(size: Size): Structure = {
    Room(Coordinate(size))
  }

  def apply(width: Int, height: Int, depth: Int, block: SimpleBlock): Structure = {
    Room(Coordinate(width - 1, height - 1, depth - 1), block)
  }

  def apply(width: Int, height: Int, depth: Int): Structure = {
    Room(width, height, depth, DEFAULT_MATERIAL)
  }
}
