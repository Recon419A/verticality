package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class StepTest extends FlatSpec with Matchers {
  "apply" should "create a three-block step" in {
    Step().voxels.size shouldBe 3
  }
}
