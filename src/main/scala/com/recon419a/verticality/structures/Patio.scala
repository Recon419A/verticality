package com.recon419a.verticality.structures

import net.morbz.minecraft.blocks.SimpleBlock

object Patio {
  def apply(): Structure = {
    Structure(Igloo(SimpleBlock.ACACIA_FENCE).voxels.filter(_.coordinate.y == 1))
  }
}
