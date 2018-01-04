package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class ClosedAtriumTest extends FlatSpec with Matchers {
  "structure" should "be an igloo" in {
    ClosedAtrium.wingStructure shouldBe Igloo()
  }
}
