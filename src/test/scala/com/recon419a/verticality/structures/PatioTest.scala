package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class PatioTest extends FlatSpec with Matchers {
  ignore should "create a one-high structure" in {
    Patio().maxCoordinate.y shouldBe 0
  }
}
