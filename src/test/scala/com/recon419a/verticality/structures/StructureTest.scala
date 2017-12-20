package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import org.scalatest.{FlatSpec, Matchers}

class StructureTest extends FlatSpec with Matchers {
  "+" should "correctly translate a single voxel" in {
    (Cuboid(1, 1, 1) + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3))
  }

  it should "correctly translate two voxels" in {
    (Cuboid(2, 1, 1) + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3), Voxel(2, 2, 3))
  }
}
