package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class ClosedAtriumTest extends FlatSpec with Matchers {
  "wingStructure" should "be an igloo" in {
    ClosedAtrium.wingStructure shouldBe Igloo()
  }

  "centerStructure" should "be a room" in {
    ClosedAtrium.centerStructure shouldBe Room()
  }
}
