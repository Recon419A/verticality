package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.MultiStoryStairsClockwiseAtrium.stairFlags
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryStairsClockwiseAtriumTest extends FlatSpec with Matchers {
  "stairFlags" should "return a null WingFlags for all nulls" in {
    stairFlags(WingFlags(), WingFlags()) shouldBe WingFlags()
  }

  it should "return a null WingFlags for a full first floor and null upper floor" in {
    stairFlags(WingFlags.fill(), WingFlags()) shouldBe WingFlags()
  }

  it should "return a full WingFlags for a full first floor and a full upper floor" in {
    stairFlags(WingFlags.fill(), WingFlags.fill()) shouldBe WingFlags.fill()
  }

  it should "return a patterned WingFlags for a patterned first floor and a full upper floor" in {
    stairFlags(WingFlags(north = true, west = true), WingFlags.fill()) shouldBe WingFlags(north = true, west = true)
  }

  it should "return an offset patterned WingFlags for a full first floor and a patterned upper floor" in {
    stairFlags(WingFlags.fill(), WingFlags(north = true, west = true)) shouldBe WingFlags(west = true, south = true)
  }
}
