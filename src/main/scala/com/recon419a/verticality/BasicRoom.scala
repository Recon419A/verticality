package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock

object BasicRoom extends HollowCuboid(Coordinate(8, 4, 8)) {
  override def voxels: Coordinate => Option[Voxel] = {
    c => {
      if (c == Coordinate(8, 4, 8)) {
        Some(Voxel(c, SimpleBlock.AIR))
      } else {
        super.voxels(c)
      }
    }
  }
}
