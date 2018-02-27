package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate, Size}
import org.scalatest.{FlatSpec, Matchers}

class StairsClockwiseTest extends FlatSpec with Matchers {
  "apply" should "create a 3x4x3 structure" in {
    StairsClockwise().maxCoordinate - StairsClockwise().minCoordinate shouldBe Coordinate(Size(3, 4, 3))
  }

  it should "create a structure in the grid origin" in {
    StairsClockwise().gridOccupied(GridCoordinate(0, 0)) shouldBe true
  }
}
