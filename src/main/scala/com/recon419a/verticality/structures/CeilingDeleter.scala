package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, ROOM_INTERNAL_SIZE, Size}
import net.morbz.minecraft.blocks.SimpleBlock

object CeilingDeleter {
  def apply(): Structure = {
    Cuboid(Size(ROOM_INTERNAL_SIZE.width, 1, ROOM_INTERNAL_SIZE.depth), SimpleBlock.AIR) + Coordinate(1, 4, 1)
  }
}
