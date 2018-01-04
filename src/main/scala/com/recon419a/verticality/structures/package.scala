package com.recon419a.verticality

import com.recon419a.verticality.util.{Coordinate, Size}
import net.morbz.minecraft.blocks.SimpleBlock

package object structures {
  val DEFAULT_BLOCK: SimpleBlock = com.recon419a.verticality.DEFAULT_BLOCK
  val ORIGIN = Coordinate(0, 0)
  val testWing = Cuboid(Size(1, 1, 2))
}
