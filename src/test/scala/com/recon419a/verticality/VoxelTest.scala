package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class VoxelTest extends FlatSpec with Matchers {
  "offset" should "offset along the correct axes" in {
    Voxel(Coordinate(1, 2, 3), DEFAULT_MATERIAL).translate(Coordinate(4, 5, 6)) shouldBe
      Voxel(Coordinate(5, 7, 9), DEFAULT_MATERIAL)
  }

  it should "work for negative values" in {
    Voxel(Coordinate(1, 2, 3), DEFAULT_MATERIAL).translate(Coordinate(5, -3, 4)) shouldBe
      Voxel(Coordinate(6, -1, 7), DEFAULT_MATERIAL)
  }

  it should "work for non-default materials" in {
    Voxel(Coordinate(1, 1, 1), SimpleBlock.BRICK_BLOCK).translate(Coordinate(1, 2, 3)) shouldBe
      Voxel(Coordinate(2, 3, 4), SimpleBlock.BRICK_BLOCK)
  }
}
