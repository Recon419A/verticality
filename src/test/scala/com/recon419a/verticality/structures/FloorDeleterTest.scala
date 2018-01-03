package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class FloorDeleterTest extends FlatSpec with Matchers {
  "apply" should "create a cuboid containing 81 squares" in {
    FloorDeleter().voxels.size shouldBe 81
  }

  it should "populate both expected corner squares" in {
    FloorDeleter().voxels should contain allOf(Voxel(1, 0, 1, SimpleBlock.AIR), Voxel(9, 0, 9, SimpleBlock.AIR))
  }

  it should "not remove floor underneath the walls" in {
    FloorDeleter().voxels should contain noneOf(Voxel(0, 0, 0, SimpleBlock.AIR), Voxel(10, 0, 10, SimpleBlock.AIR))
  }
}
