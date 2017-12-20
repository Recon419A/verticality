package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.DEFAULT_MATERIAL
import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World
import org.mockito.Mockito.verify
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class StructureTest extends FlatSpec with Matchers  with MockitoSugar {
  "+" should "correctly translate a single voxel" in {
    (Cuboid(1, 1, 1) + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3))
  }

  it should "correctly translate two voxels" in {
    (Cuboid(2, 1, 1) + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3), Voxel(2, 2, 3))
  }

  "renderTo" should "call setBlock with the correct arguments" in {
    val mockWorld = mock[World]
    Structure(Set(Voxel(0, 1, 2), Voxel(3, 4, 8, SimpleBlock.ACACIA_FENCE))).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, 2, DEFAULT_MATERIAL)
    verify(mockWorld).setBlock(3, 4, 8, SimpleBlock.ACACIA_FENCE)
  }
}
