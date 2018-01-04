package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class ClosedPatioTest extends FlatSpec with Matchers {
  "apply" should "create a structure two high" in {
    ClosedPatio().maxCoordinate.y shouldBe 1
  }

  it should "create a structure with no voxels on the first layer" in {
    ClosedPatio().voxels.filter(_.coordinate.y == 0) shouldBe Set.empty[Voxel]
  }

  it should "create a structure with air on the inside" in {
    ClosedPatio().voxels should contain allOf(Voxel(4, 1, 15, SimpleBlock.AIR), Voxel(6, 1, 13, SimpleBlock.AIR))
  }

  ignore should "create a structure with a door" in {

  }
}
