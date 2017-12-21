package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Size, Voxel}
import org.scalatest.{FlatSpec, Matchers}

class HallwayTest extends FlatSpec with Matchers {
  "apply" should "throw an error for hallways of less than 3x3" in {
    assertThrows[AssertionError] {
      Hallway(Size(2, 2, 2))
    }
  }

  it should "throw an error for hallways of zero and negative depth but not for positive depth" in {
    assertThrows[AssertionError] {
      Hallway(Size(3, 3, 0))
    }
    assertThrows[AssertionError] {
      Hallway(Size(3, 3, -2))
    }
    Hallway(Size(3, 3, 1))
  }

  it should "have a central hole in the 3x3 case" in {
    Hallway(Size(3, 3, 2)).voxel(1, 1, 0) shouldBe None
    Hallway(Size(3, 3, 2)).voxel(1, 1, 1) shouldBe None
  }

  it should "have a surrounding ring in the 3x3 case" in {
    Hallway(Size(3, 3, 2)).voxels should contain allOf (Voxel(0, 0, 0), Voxel(2, 2, 1), Voxel(2, 2, 0), Voxel(0, 1, 1))
    Hallway(Size(3, 3, 2)).voxels.size shouldBe 16
  }

  it should "scale in both dimensions" in {
    Hallway(Size(4, 4, 2)).voxels.size shouldBe 24
  }
}
