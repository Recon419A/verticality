package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock

case class FilledCuboid(maxCoordinate: Coordinate) extends Structure {
  override def blocks: Coordinate => SimpleBlock = _ => DEFAULT_MATERIAL
}