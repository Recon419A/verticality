package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.MultiStoryPatioAtrium.{ceilingFlags, floorFlags, patioFlags}
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryPatioAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a PatioAtrium" in {
    MultiStoryPatioAtrium.atrium shouldBe PatioAtrium
  }

  "ceilingFlags" should "return three layers of all-false WingFlags for an all-false default WingFlags" in {
    ceilingFlags(Seq(WingFlags())) shouldBe Seq.fill(3)(WingFlags())
  }

  it should "return a fill, an empty, and an empty for an all-true WingFlags" in {
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

  it should "produce a structure containing two more layers than the provided one" in {
    ceilingFlags(Seq.fill(7)(WingFlags())).size shouldBe 9
  }

  "floorFlags" should "return a structure containing two more layers than the provided one" in {
    floorFlags(Seq.fill(9)(WingFlags())).size shouldBe 11
  }

  it should "produce an offset two-high structure for a two-story pattern" in {
    val floor1 = WingFlags(north = true, east = true)
    val floor2 = WingFlags(west = true, east = true)
    floorFlags(Seq(floor1, floor2)) shouldBe Seq.fill(2)(WingFlags()) ++ Seq(floor1, floor2)
  }

  "patioFlags" should "return an empty for a level with no floors and no ceilings" in {
    patioFlags(WingFlags(), WingFlags(), WingFlags()) shouldBe WingFlags()
  }

  it should "return a fill for a level with all floors and no ceilings and no wings" in {
    patioFlags(WingFlags.fill(), WingFlags(), WingFlags()) shouldBe WingFlags.fill()
  }

  it should "return an empty for a level with all floors and all ceilings" in {
    patioFlags(WingFlags.fill(), WingFlags.fill(), WingFlags()) shouldBe WingFlags()
  }

  it should "return a pattern for a level with all floors and a pattern ceiling" in {
    patioFlags(WingFlags.fill(), WingFlags(east = true, south = true), WingFlags()) shouldBe
      WingFlags(north = true, west = true)
  }

  it should "return a pattern for a level with pattern floors and no ceiling" in {
    patioFlags(WingFlags(east = true, south = true), WingFlags(), WingFlags()) shouldBe
      WingFlags(east = true, south = true)
  }

  it should "return an empty for a level with all floors, no ceiling, and all wings" in {
    patioFlags(WingFlags.fill(), WingFlags(), WingFlags.fill()) shouldBe WingFlags()
  }

  it should "return a sequence the same length as the one passed in" in {
    patioFlags(Seq.fill(7)(WingFlags())).size shouldBe 7
  }

  it should "have no patios in a single-floor fill" in {
    patioFlags(Seq(WingFlags.fill())) shouldBe Seq(WingFlags())
  }

  it should "have a second-story patio in a single-floor fill topped by an empty" in {
    patioFlags(Seq(WingFlags.fill(), WingFlags())) shouldBe Seq(WingFlags(), WingFlags.fill())
  }

  it should "have no patios in a fill-empty-fill arrangement" in {
    patioFlags(Seq(WingFlags.fill(), WingFlags(), WingFlags.fill())) shouldBe Seq.fill(3)(WingFlags())
  }

  it should "have a fill patio on the third layer for an empty-fill-empty arrangement" in {
    patioFlags(Seq(WingFlags(), WingFlags.fill(), WingFlags())) shouldBe Seq(WingFlags(), WingFlags(), WingFlags.fill())
  }

  it should "have a patio on the second layer for a fill-empty-empty-fill arrangement" in {
    patioFlags(Seq(WingFlags.fill(), WingFlags(), WingFlags(), WingFlags.fill())) shouldBe
      Seq(WingFlags(), WingFlags.fill(), WingFlags(), WingFlags())
  }

  it should "have no patios in a fill-fill arrangement" in {
    patioFlags(Seq(WingFlags.fill(), WingFlags.fill())) shouldBe Seq(WingFlags(), WingFlags())
  }
}