package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.MultiStoryPatioAtrium.ceilingFlags
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryPatioAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a PatioAtrium" in {
    MultiStoryPatioAtrium.atrium shouldBe PatioAtrium
  }

  "ceilingFlags" should "return three layers of all-false WingFlags for an all-false default WingFlags" in {
    ceilingFlags(Seq(WingFlags())) shouldBe Seq.fill(3)(WingFlags())
  }

  it should "return all trues, all falses, and all falses for an all-true WingFlags" in {
    ceilingFlags(Seq(WingFlags.fill())) shouldBe Seq(WingFlags.fill()) ++ Seq.fill(2)(WingFlags())
  }

  it should "produce an offset two-high structure for a two-story fill" in {
    ceilingFlags(Seq.fill(2)(WingFlags.fill())) shouldBe Seq.fill(2)(WingFlags.fill()) ++ Seq.fill(2)(WingFlags())
  }

  it should "produce a offset two-high structure for a a two-story pattern" in {
    val floor1 = WingFlags(north = true, east = true)
    val floor2 = WingFlags(west = true, east = true)
    ceilingFlags(Seq(floor1, floor2)) shouldBe Seq(floor1, floor2) ++ Seq.fill(2)(WingFlags())
  }
}