package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class ClosedPatioTest extends FlatSpec with Matchers {
  private val testClosedPatio = ClosedPatio()

  "apply" should "create a structure three high" in {
    testClosedPatio.maxCoordinate.y shouldBe 2
  }

  it should "create a structure with no voxels on the first layer except the step" in {
    testClosedPatio.voxels.count(_.coordinate.y == 0) shouldBe 3
  }

  it should "create a structure with air on the inside" in {
    testClosedPatio.voxels should contain allOf(Voxel(4, 1, 15, SimpleBlock.AIR), Voxel(6, 1, 13, SimpleBlock.AIR))
  }

  it should "create a structure made of acacia fence, air, and the default block" in {
    testClosedPatio.voxels.map(_.block) shouldBe Set(SimpleBlock.ACACIA_FENCE, SimpleBlock.AIR, DEFAULT_BLOCK)
  }

  it should "create a structure with only three default blocks" in {
    testClosedPatio.voxels.count(_.block == DEFAULT_BLOCK) shouldBe 3
  }

  it should "create a structure that includes a 1x2 door" in {
    testClosedPatio.voxels should contain allOf(Voxel(5, 1, 0, SimpleBlock.AIR), Voxel(5, 2, 0, SimpleBlock.AIR))
  }

  it should "create a structure that doesn't include a slice of the normal hallway door" in {
    testClosedPatio.voxels should contain noneOf(Voxel(4, 1, 0, SimpleBlock.AIR), Voxel(6, 1, 0, SimpleBlock.AIR))
  }

  it should "create a structure with a step in the correct position" in {
    testClosedPatio.voxels should contain allOf(Voxel(4, 0, -1), Voxel(5, 0, -1), Voxel(6, 0, -1))
  }
}
