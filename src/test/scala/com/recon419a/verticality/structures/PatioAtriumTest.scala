package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class PatioAtriumTest extends FlatSpec with Matchers {
  "wingStructure" should "be a closed patio" in {
    PatioAtrium.wingStructure shouldBe ClosedPatio()
  }

  "centerStructure" should "be the null structure" in {
    PatioAtrium.centerStructure shouldBe Structure()
  }
}
