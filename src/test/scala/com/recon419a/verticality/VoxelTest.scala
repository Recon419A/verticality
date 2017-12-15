package com.recon419a.verticality

import org.scalatest.{FlatSpec, Matchers}

class VoxelTest extends FlatSpec with Matchers {
  "offset" should "offset along the correct axes" in {
    Voxel(Coordinate(1, 2, 3), DEFAULT_MATERIAL).offset(Coordinate(4, 5, 6)) shouldBe
      Voxel(Coordinate(5, 7, 9), DEFAULT_MATERIAL)
  }
}
