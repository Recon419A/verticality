package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class MultiStoryOpenAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be an open atrium" in {
    MultiStoryOpenAtrium.atrium shouldBe OpenAtrium
  }
}
