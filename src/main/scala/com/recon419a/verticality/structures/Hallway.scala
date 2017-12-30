package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import net.morbz.minecraft.blocks.SimpleBlock

object Hallway {
  def apply(): Structure = {
    val borehole = Cuboid(Size(3, 3, 11), SimpleBlock.AIR) + Coordinate(1, 1)
    (Cuboid(Size(5, 5, 11)) + borehole) + Coordinate(3, 0)
  }
}