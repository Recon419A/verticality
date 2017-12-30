package com.recon419a.verticality.util

import org.scalatest.{FlatSpec, Matchers}

class GridSizeTest extends FlatSpec with Matchers {
  "apply" should "return 11 for a room of GridSize 1" in {
    GridSize(1, 1) shouldBe Size(11, 5, 11)
  }

  it should "return the correct size for a 2x1 grid" in {
    GridSize(2, 1) shouldBe Size(21, 5, 11)
  }

  it should "return the correct size for a 2x2 grid" in {
    GridSize(2, 2) shouldBe Size(21, 9, 11)
  }

  it should "return the correct size for a 2x2x3 grid" in {
    GridSize(2, 2, 3) shouldBe Size(21, 9, 31)
  }
}
