package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate
import org.scalatest.{FlatSpec, Matchers}

class StairsClockwiseAtriumTest extends FlatSpec with Matchers {
  "apply" should "place all wings in the center" in {
    (StairsClockwiseAtrium().maxCoordinate <<= GridCoordinate(1, 1, 1)) shouldBe true
    (GridCoordinate(0, 0) <<= StairsClockwiseAtrium().minCoordinate) shouldBe true

  }

  "centerStructure" should "be the null structure" in {
    StairsClockwiseAtrium.centerStructure shouldBe Structure()
  }
}
