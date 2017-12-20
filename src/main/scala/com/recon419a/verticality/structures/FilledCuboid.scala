package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, DEFAULT_MATERIAL, ORIGIN, Structure, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock

trait FilledCuboid extends Structure {
  val material: SimpleBlock = DEFAULT_MATERIAL

  def voxel: Coordinate => Option[Voxel] = c => {
    if ((ORIGIN to maxCoordinate).contains(c)) Some(Voxel(c, material)) else None
  }
}

case class CustomFilledCuboid(maxCoordinate: Coordinate, offset: Coordinate) extends FilledCuboid