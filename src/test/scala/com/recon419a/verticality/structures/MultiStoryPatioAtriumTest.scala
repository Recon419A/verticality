package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class MultiStoryPatioAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a PatioAtrium" in {
    MultiStoryPatioAtrium.atrium shouldBe PatioAtrium
  }
}
