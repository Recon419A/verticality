package com.recon419a.verticality


import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.FlatSpec
import org.scalatest.Matchers


class StructureTest extends FlatSpec with Matchers {
  "translatedVoxels" should "properly translate voxels" in {
    TestStructure.translatedVoxel(Coordinate(0, 0, 0)) shouldBe None
    TestStructure.translatedVoxel(Coordinate(0, 1, 1)) shouldBe Some(Voxel(Coordinate(0, 1, 1), SimpleBlock.BRICK_BLOCK))
    TestStructure.translatedVoxel(Coordinate(1, 2, 2)) shouldBe None
  }

  "voxelList" should "list non-None voxels" in {
    TestStructure.voxelList shouldBe List(
      Voxel(Coordinate(0, 0, 0), SimpleBlock.BRICK_BLOCK),
      Voxel(Coordinate(0, 0, 1), SimpleBlock.BOOKSHELF),
      Voxel(Coordinate(0, 1, 0), SimpleBlock.CLAY),
      Voxel(Coordinate(1, 0, 0), SimpleBlock.COAL_BLOCK),
      Voxel(Coordinate(1, 1, 0), SimpleBlock.COBBLESTONE))
  }

  "translatedVoxelList" should "list non-None voxels with appropriate translation" in {
    TestStructure.translatedVoxelList shouldBe List(
      Voxel(Coordinate(0, 1, 1), SimpleBlock.BRICK_BLOCK),
      Voxel(Coordinate(0, 1, 2), SimpleBlock.BOOKSHELF),
      Voxel(Coordinate(0, 2, 1), SimpleBlock.CLAY),
      Voxel(Coordinate(1, 1, 1), SimpleBlock.COAL_BLOCK),
      Voxel(Coordinate(1, 2, 1), SimpleBlock.COBBLESTONE))
  }

  "contains" should "be false for a value in the non-translated bounding box" in {
    TestStructure.contains(Coordinate(0, 0, 0)) shouldBe false
  }

  it should "be true for a value in the translated bounding box only" in {
    TestStructure.contains(Coordinate(1, 2, 2)) shouldBe true
  }

  it should "be false for a value aligned with the testing zone in two dimensions" in {
    TestStructure.contains(Coordinate(-1, 2, 2)) shouldBe false
  }
}
