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

  "contains" should "return true for a value in the box" in {
    StructureDummy.contains(Coordinate(2, 2, 2)) shouldBe true
  }

  it should "return false for a value less than the box in all dimensions" in {
    StructureDummy.contains(Coordinate(-1, -1, -1)) shouldBe false
  }

  it should "return false for a value greater than the box in one dimension" in {
    StructureDummy.contains(Coordinate(2, 2, 5)) shouldBe false
  }

  it should "return true for a value along the lesser wall" in {
    StructureDummy.contains(Coordinate(2, 0, 2)) shouldBe true
  }

  it should "return true for the greatest value in the box" in {
    StructureDummy.contains(Coordinate(4, 4, 4)) shouldBe true
  }

  it should "return true for the least value in the box" in {
    StructureDummy.contains(Coordinate(0, 0, 0)) shouldBe true
  }

  object StructureDummy extends Structure {
    override def voxel: Coordinate => Option[Voxel] = { _ => None }

    override val maxCoordinate: Coordinate = Coordinate(4, 4, 4)

    override def offset: Coordinate = ORIGIN
  }

}
