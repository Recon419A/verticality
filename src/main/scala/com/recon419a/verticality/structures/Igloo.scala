package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate
import net.morbz.minecraft.blocks.SimpleBlock

object Igloo {
  def apply(block: SimpleBlock = DEFAULT_BLOCK): Structure = {
    (Room() + GridCoordinate(0, 0, 1)) + Hallway()
  }
}
