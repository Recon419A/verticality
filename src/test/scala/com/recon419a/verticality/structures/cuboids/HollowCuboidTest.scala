package com.recon419a.verticality.structures.cuboids

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.{DEFAULT_MATERIAL, ORIGIN}
import org.scalatest.{FlatSpec, Matchers}

class HollowCuboidTest extends FlatSpec with Matchers {
  "voxel" should "fill in a 1x1 cuboid" in {
    val test = HollowCuboid(Coordinate(0, 0, 0), ORIGIN)
    test.translatedVoxel(Coordinate(0, 0, 0)) shouldBe Some(Voxel(Coordinate(0,0,0), DEFAULT_MATERIAL))
  }

  it should "fill in a 2x2 cuboid" in {
    val test = HollowCuboid(Coordinate(1, 1, 1), ORIGIN)
    for (c <- Coordinate(0, 0, 0) to Coordinate(1, 1, 1))
    test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
  }

  it should "fill in all but the middle of a 3x3 cuboid" in {
    val test = HollowCuboid(Coordinate(2, 2, 2), ORIGIN)
    for (c <- Coordinate(0, 0, 0) to Coordinate(2, 2, 2))
      if (c != Coordinate(1, 1, 1)) {
        test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
      } else {
        test.translatedVoxel(c) shouldBe None
      }
  }

  it should "not fill things outside the cuboid's boundaries" in {
    val test = HollowCuboid(Coordinate(2, 2, 2), ORIGIN)
    for (c <- Coordinate(-1, -1, -1) to Coordinate(3, 3, 3))
      if (c != Coordinate(1, 1, 1) && (Coordinate(0, 0, 0) to Coordinate(2, 2, 2)).contains(c)) {
        test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
      } else {
        test.translatedVoxel(c) shouldBe None
      }
  }
}
