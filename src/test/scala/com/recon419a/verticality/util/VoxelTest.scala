package com.recon419a.verticality.util

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class VoxelTest extends FlatSpec with Matchers with MockitoSugar {
  "translate" should "offset along the correct axes" in {
    Voxel(1, 2, 3) + Coordinate(4, 5, 6) shouldBe Voxel(5, 7, 9, DEFAULT_BLOCK)
  }

  it should "work for negative values" in {
    Voxel(1, 2, 3) + Coordinate (5, -3, 4) shouldBe Voxel(6, -1, 7)
  }

  it should "work for non-default materials" in {
    Voxel(1, 1, 1, SimpleBlock.BRICK_BLOCK) + Coordinate(1, 2, 3) shouldBe Voxel(2, 3, 4, SimpleBlock.BRICK_BLOCK)
  }

  it should "infer zero for a missing z value" in {
    Voxel(1, 2) + Coordinate(1, 2) shouldBe Voxel(2, 4)
  }

  "renderTo" should "call World.setBlock with the correct arguments" in {
    val mockWorld = mock[World]
    Voxel(0, 1, -4).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, -4, DEFAULT_BLOCK)
  }

  it should "work for non-default materials" in {
    val mockWorld = mock[World]
    Voxel(0, 1, -4, SimpleBlock.ACACIA_FENCE).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, -4, SimpleBlock.ACACIA_FENCE)
  }

  "apply" should "correctly construct a coordinate" in {
    Voxel(1, 2, 3, DEFAULT_BLOCK) shouldBe Voxel(Coordinate(1, 2, 3), DEFAULT_BLOCK)
  }

  it should "default to the default material" in {
    Voxel(1, 2, 3) shouldBe Voxel(1, 2, 3, DEFAULT_BLOCK)
  }

  it should "default to zero for the z-axis when passed a blcok" in {
    Voxel(1, 2, SimpleBlock.AIR) shouldBe Voxel(1, 2, 0, SimpleBlock.AIR)
  }

  it should "default to zero for z when passed no block" in {
    Voxel(1, 2) shouldBe Voxel(1, 2, 0)
  }
}
