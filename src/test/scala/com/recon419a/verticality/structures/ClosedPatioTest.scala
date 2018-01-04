package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class ClosedPatioTest extends FlatSpec with Matchers {
  "apply" should "create a structure three high" in {
    ClosedPatio().maxCoordinate.y shouldBe 2
  }

  it should "create a structure with no voxels on the first layer" in {
    ClosedPatio().voxels.filter(_.coordinate.y == 0) shouldBe Set.empty[Voxel]
  }

  it should "create a structure with air on the inside" in {
    ClosedPatio().voxels should contain allOf(Voxel(4, 1, 15, SimpleBlock.AIR), Voxel(6, 1, 13, SimpleBlock.AIR))
  }

  it should "create a structure made of acacia fence and air" in {
    ClosedPatio().voxels.map(_.block) shouldBe Set(SimpleBlock.ACACIA_FENCE, SimpleBlock.AIR)
  }

  it should "create a structure that includes a 1x2 door" in {
    ClosedPatio().voxels should contain allOf(Voxel(5, 1, 0, SimpleBlock.AIR), Voxel(5, 2, 0, SimpleBlock.AIR))
  }

  it should "create a structure that doesn't include a slice of the normal hallway door" in {
    ClosedPatio().voxels should contain noneOf(Voxel(4, 1, 0, SimpleBlock.AIR), Voxel(6, 1, 0, SimpleBlock.AIR))
  }
}
