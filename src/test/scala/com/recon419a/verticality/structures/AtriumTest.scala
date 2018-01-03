package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{GridCoordinate, Size}
import org.scalatest.{FlatSpec, Matchers}

class AtriumTest extends FlatSpec with Matchers {
  private val testWing = Cuboid(Size(1, 1))

  "actualWings" should "contain no wings when passed all false" in {
    TestAtrium.actualWings(Seq(false, false, false, false)) shouldBe List.empty[Structure]
  }

  it should "contain one wing when passed one true flag" in {
    TestAtrium.actualWings(Seq(true, false, false, false)).size shouldBe 1
  }

  it should "contain one wing when passed a different true flag" in {
    TestAtrium.actualWings(Seq(false, true, false, false)).size shouldBe 1
  }

  it should "contain four wings when passed all four true flags" in {
    TestAtrium.actualWings(Seq(true, true, true, true)).size shouldBe 4
  }

  it should "correctly generate a north wing" in {
    TestAtrium.actualWings(Seq(true, false, false, false)).head shouldBe testWing.rotateFlip + GridCoordinate(0, 0, -1)
  }

  it should "correctly generate an east wing" in {
    TestAtrium.actualWings(Seq(false, true, false, false)).head shouldBe (
      testWing.rotateCounterClockwise + GridCoordinate(1, 0))
  }

  it should "correctly generate a south wing" in {
    TestAtrium.actualWings(Seq(false, false, true, false)).head shouldBe testWing + GridCoordinate(0, 0, 1)
  }

  it should "correctly generate a west wing" in {
    TestAtrium.actualWings(Seq(false, false, false, true)).head shouldBe (
      testWing.rotateClockwise + GridCoordinate(-1, 0))
  }

  object TestAtrium extends Atrium {
    val structure: Structure = testWing
  }

}
