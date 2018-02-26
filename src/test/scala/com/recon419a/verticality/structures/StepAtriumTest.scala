package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class StepAtriumTest extends FlatSpec with Matchers {
  "wingStructure" should "be a step" in {
    StepAtrium.wingStructure shouldBe Step()
  }

  "centerStructure" should "be the null structure" in {
    StepAtrium.centerStructure shouldBe Structure()
  }
}