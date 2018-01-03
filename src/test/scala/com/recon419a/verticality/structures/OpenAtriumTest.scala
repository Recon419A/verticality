package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class OpenAtriumTest extends FlatSpec with Matchers {
  "structure" should "be a hallway" in {
    OpenAtrium.structure shouldBe Hallway()
  }
}
