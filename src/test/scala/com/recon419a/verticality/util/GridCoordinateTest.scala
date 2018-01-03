package com.recon419a.verticality.util

import org.scalatest.{FlatSpec, Matchers}

class GridCoordinateTest extends FlatSpec with Matchers {
  "apply" should "return the correct offset for the coordinate (0, 0)" in {
    GridCoordinate(0, 0) shouldBe Coordinate(0, 0)
  }

  it should "return the correct offset for the coordinate (1, 0)" in {
    GridCoordinate(1, 0) shouldBe Coordinate(10, 0)
  }

  it should "return the correct offset for the coordinate (1, 2, 3)" in {
    GridCoordinate(1, 2, 3) shouldBe Coordinate(10, 8, 30)
  }
}
