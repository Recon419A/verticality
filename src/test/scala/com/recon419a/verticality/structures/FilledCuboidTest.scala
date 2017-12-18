package com.recon419a.verticality.structures

import com.recon419a.verticality.{Coordinate, DEFAULT_MATERIAL, ORIGIN, Voxel}
import org.scalatest.{FlatSpec, Matchers}

class FilledCuboidTest extends FlatSpec with Matchers {
  "voxel" should "fill in a 1x1 cuboid" in {
    val test = FilledCuboid(Coordinate(0, 0, 0), ORIGIN)
    test.translatedVoxel(Coordinate(0, 0, 0)) shouldBe Some(Voxel(Coordinate(0,0,0), DEFAULT_MATERIAL))
  }

  it should "fill in a 2x2 cuboid" in {
    val test = FilledCuboid(Coordinate(1, 1, 1), ORIGIN)
    for (c <- Coordinate(0, 0, 0) to Coordinate(1, 1, 1))
      test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
  }

  it should "fill in a 3x3 cuboid" in {
    val test = FilledCuboid(Coordinate(2, 2, 2), ORIGIN)
    for (c <- Coordinate(0, 0, 0) to Coordinate(2, 2, 2))
      test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
  }

  it should "not fill things outside the cuboid's boundaries" in {
    val test = FilledCuboid(Coordinate(2, 2, 2), ORIGIN)
    for (c <- Coordinate(-1, -1, -1) to Coordinate(3, 3, 3))
      if ((Coordinate(0, 0, 0) to Coordinate(2, 2, 2)).contains(c)) {
        test.translatedVoxel(c) shouldBe Some(Voxel(c, DEFAULT_MATERIAL))
      } else {
        test.translatedVoxel(c) shouldBe None
      }
  }
}
