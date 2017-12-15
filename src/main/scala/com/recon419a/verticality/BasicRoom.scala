package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock

object BasicRoom extends HollowCuboid(Coordinate(8, 4, 8), DEFAULT_MATERIAL) {
  this(8, 4, 8) = Voxel(Coordinate(8, 4, 8), SimpleBlock.AIR)
}
