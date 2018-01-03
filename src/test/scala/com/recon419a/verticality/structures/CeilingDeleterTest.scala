package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class CeilingDeleterTest extends FlatSpec with Matchers {
  "apply" should "create a cuboid containing 81 squares" in {
    CeilingDeleter().voxels.size shouldBe 81
  }

  it should "populate both expected corner squares" in {
    CeilingDeleter().voxels should contain allOf(Voxel(1, 4, 1, SimpleBlock.AIR), Voxel(9, 4, 9, SimpleBlock.AIR))
  }

  it should "not remove floor above the walls" in {
    CeilingDeleter().voxels should contain noneOf(Voxel(0, 4, 0, SimpleBlock.AIR), Voxel(10, 4, 10, SimpleBlock.AIR))
  }
}
