package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import org.scalatest.{FlatSpec, Matchers}

class GridTest extends FlatSpec with Matchers {
  "apply" should "populate the origin voxel for a 1x1 case" in {
    Grid(1, 1, 1, Coordinate(3, 3, 3)).voxels shouldBe Set(Voxel(0, 0, 0))
  }

  it should "populate the corner voxels for a 3x3 grid with spacing 2" in {
    Grid(3, 3, 3, Coordinate(2, 2, 2)).voxels shouldBe Set(Voxel(0, 0, 0), Voxel(0, 0, 2), Voxel(0, 2, 0),
      Voxel(0, 2, 2), Voxel(2, 0, 0), Voxel(2, 0, 2), Voxel(2, 2, 0), Voxel(2, 2, 2))
  }

  it should "be aligned to the correct axes" in {
    Grid(3, 4, 5, Coordinate(2, 3, 4)).voxels shouldBe Set(Voxel(0, 0, 0), Voxel(0, 0, 4), Voxel(0, 3, 0),
      Voxel(0, 3, 4), Voxel(2, 0, 0), Voxel(2, 0, 4), Voxel(2, 3, 0), Voxel(2, 3, 4))
  }
}
