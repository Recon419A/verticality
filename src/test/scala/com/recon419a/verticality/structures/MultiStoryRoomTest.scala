package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.{ORIGIN, DEFAULT_MATERIAL}
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryRoomTest extends FlatSpec with Matchers {
  "a room of height 1" should "be 5 tall" in {
    MultiStoryRoom(ORIGIN, 1).translatedVoxel(Coordinate(3, 4, 3)) shouldBe
      Some(Voxel(Coordinate(3, 4, 3), DEFAULT_MATERIAL))
  }

  "a room of height 2" should "be 9 tall" in {
    MultiStoryRoom(ORIGIN, 2).translatedVoxel(Coordinate(3, 8, 3)) shouldBe
      Some(Voxel(Coordinate(3, 8, 3), DEFAULT_MATERIAL))
  }

  "a room of height 3" should "be 13 tall" in {
    MultiStoryRoom(ORIGIN, 3).translatedVoxel(Coordinate(3, 12, 3)) shouldBe
      Some(Voxel(Coordinate(3, 12, 3), DEFAULT_MATERIAL))
  }
}
