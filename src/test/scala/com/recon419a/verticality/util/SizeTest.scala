package com.recon419a.verticality.util

import org.scalatest.{FlatSpec, Matchers}

class SizeTest extends FlatSpec with Matchers {
  "apply" should "parse a coordinate correctly" in {
    Size(Coordinate(1, 2, 3)) shouldBe Size(2, 3, 4)
  }

  it should "use one for the default depth" in {
    Size(2, 3) shouldBe Size(2, 3, 1)
  }

  ">>=" should "return true for a size larger in all three dimensions" in {
    (Size(4, 4, 4) >>= Size(3, 3, 3)) shouldBe true
  }

  it should "return true for a size equal in all three dimensions" in {
    (Size(3, 3, 3) >>= Size(3, 3, 3)) shouldBe true
  }

  it should "return false for a size larger in volume but smaller in one dimension" in {
    (Size(100, 100, 2) >>= Size(3, 3, 3)) shouldBe false
  }

  it should "return false for a size smaller in all dimensions" in {
    (Size(2, 2, 2) >>= Size(3, 3, 3)) shouldBe false
  }
}
