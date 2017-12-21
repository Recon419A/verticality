package com.recon419a.verticality.util

import org.scalatest.{FlatSpec, Matchers}

class SizeTest extends FlatSpec with Matchers {
  "apply" should "parse a coordinate correctly" in {
    Size(Coordinate(1, 2, 3)) shouldBe Size(2, 3, 4)
  }

  it should "use one for the default depth" in {
    Size(2, 3) shouldBe Size(2, 3, 1)
  }
}
