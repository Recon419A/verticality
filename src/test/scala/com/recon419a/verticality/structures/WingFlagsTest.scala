package com.recon419a.verticality.structures

import org.scalatest.{FlatSpec, Matchers}

class WingFlagsTest extends FlatSpec with Matchers {
  private val testWingFlags = WingFlags()

  "length" should "be four" in {
    testWingFlags.length shouldBe 4
  }

  "next" should "yield the sequence" in {
    testWingFlags shouldBe Seq(false, false, false, false)
  }

  "apply" should "treat north as the head" in {
    WingFlags(north = true).head shouldBe true
    testWingFlags.head shouldBe false
  }

  it should "have east as the 1st element" in {
    WingFlags(east = true)(1) shouldBe true
    testWingFlags(1) shouldBe false
  }

  it should "have south as the 2nd element" in {
    WingFlags(south = true)(2) shouldBe true
    testWingFlags(2) shouldBe false
  }

  it should "have west as the 3rd element" in {
    WingFlags(west = true)(3) shouldBe true
    testWingFlags(3) shouldBe false
  }

  it should "throw an exception for the 4th element" in {
    an[IndexOutOfBoundsException] should be thrownBy testWingFlags(4)
  }

  it should "default to false" in {
    testWingFlags.north shouldBe false
    testWingFlags.east shouldBe false
    testWingFlags.south shouldBe false
    testWingFlags.west shouldBe false
  }

  "north" should "return north" in {
    WingFlags(north = true).north shouldBe true
  }

  "&&" should "return all false if one of the values is all false" in {
    testWingFlags && WingFlags(east = true) shouldBe testWingFlags
  }

  it should "take the logical and for a basic case" in {
    WingFlags(east = true, south = true) && WingFlags(east = true, north = true) shouldBe WingFlags(east = true)
  }

  "fill" should "return all true" in {
    WingFlags.fill() shouldBe WingFlags(north = true, east = true, south = true, west = true)
  }
}
