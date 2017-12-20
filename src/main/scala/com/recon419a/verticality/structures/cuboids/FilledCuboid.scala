package com.recon419a.verticality.structures.cuboids

import com.recon419a.verticality._
import com.recon419a.verticality.structures.Structure
import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.{ORIGIN, DEFAULT_MATERIAL}
import net.morbz.minecraft.blocks.SimpleBlock

trait FilledCuboid extends Structure {
  val material: SimpleBlock = DEFAULT_MATERIAL

  def voxel: Coordinate => Option[Voxel] = c => {
    if ((ORIGIN to maxCoordinate).contains(c)) Some(util.Voxel(c, material)) else None
  }
}

