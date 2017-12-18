package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class MultiStructureTest extends FlatSpec with Matchers {
  "voxel" should "return the single voxel for a single component" in {
    for (c <- Coordinate(0, 0, 0) to Coordinate(3, 3, 3)) {
      TestSingleComponentMultiStructure.voxel(c) shouldBe TestOffsetStructure.translatedVoxel(c)
    }
  }

  it should "return the combined voxels of two structures" in {
    TestMultiComponentMultiStructure.translatedVoxelList.toSet shouldBe Set(
      Voxel(Coordinate(0, 0, 0), SimpleBlock.BRICK_BLOCK),
      Voxel(Coordinate(0, 0, 1), SimpleBlock.BOOKSHELF),
      Voxel(Coordinate(0, 1, 0), SimpleBlock.CLAY),
      Voxel(Coordinate(0, 1, 1), SimpleBlock.BRICK_BLOCK),
      Voxel(Coordinate(0, 1, 2), SimpleBlock.BOOKSHELF),
      Voxel(Coordinate(0, 2, 1), SimpleBlock.CLAY),
      Voxel(Coordinate(1, 0, 0), SimpleBlock.COAL_BLOCK),
      Voxel(Coordinate(1, 1, 0), SimpleBlock.COBBLESTONE),
      Voxel(Coordinate(1, 1, 1), SimpleBlock.COAL_BLOCK),
      Voxel(Coordinate(1, 2, 1), SimpleBlock.COBBLESTONE)
    )
  }

  it should "return the option earliest in the list for overlapping structures" in {
    TestOverlappingComponentMultiStructure.translatedVoxelList.toSet shouldBe Set(
      Voxel(Coordinate(0, 0, 0), SimpleBlock.DIAMOND_BLOCK),
      Voxel(Coordinate(0, 0, 1), SimpleBlock.BOOKSHELF),
      Voxel(Coordinate(0, 1, 0), SimpleBlock.CLAY),
      Voxel(Coordinate(1, 0, 0), SimpleBlock.COAL_BLOCK),
      Voxel(Coordinate(1, 1, 0), SimpleBlock.COBBLESTONE)
    )
  }
}
