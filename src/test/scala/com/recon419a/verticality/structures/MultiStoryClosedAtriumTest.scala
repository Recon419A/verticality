package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class MultiStoryClosedAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a closed atrium" in {
    MultiStoryClosedAtrium.atrium shouldBe ClosedAtrium
  }
}
