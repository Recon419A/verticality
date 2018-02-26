package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class MultiStoryStepAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a StepAtrium" in {
    MultiStoryStepAtrium.atrium shouldBe StepAtrium
  }
}
