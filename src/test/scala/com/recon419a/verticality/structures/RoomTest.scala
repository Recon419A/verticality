package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class RoomTest extends FlatSpec with Matchers {
  "apply" should "throw an error for rooms of less than 3x3x3" in {
    assertThrows[AssertionError] {
      Room(Size(3, 3, 2))
    }
    assertThrows[AssertionError] {
      Room(Size(3, 2, 3))
    }
    assertThrows[AssertionError] {
      Room(Size(2, 3, 3))
    }
    Room(Size(3, 3, 3))
  }

  it should "create a room with a central hole for the 3x3x3 case" in {
    Room(Size(3, 3, 3)).voxel(1, 1, 1) shouldBe None
    Room(Size(3, 3, 3)).voxels.size shouldBe 26
    Room(Size(3, 3, 3)).voxels should contain allOf (Voxel(0, 0, 0), Voxel(1, 2, 2), Voxel(2, 2, 2))
  }

  it should "work for non-default materials" in {
    Room(Size(3, 3, 3), SimpleBlock.ACACIA_FENCE).voxel(2, 2, 2) shouldBe Some(Voxel(2, 2, 2, SimpleBlock.ACACIA_FENCE))
  }
}
