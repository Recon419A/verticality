package com.recon419a.verticality.structures.doors

import com.recon419a.verticality.structures.FilledCuboid
import net.morbz.minecraft.blocks.SimpleBlock

trait Door extends FilledCuboid {
  override val material: SimpleBlock = SimpleBlock.AIR
}
