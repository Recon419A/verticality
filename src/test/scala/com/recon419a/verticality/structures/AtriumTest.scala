package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate
import org.scalatest.{FlatSpec, Matchers}

class AtriumTest extends FlatSpec with Matchers {
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

  "apply" should "generate a standard room if all wings are set to false" in {
    TestAtrium(Seq(false, false, false, false)) shouldBe Room()
  }

  it should "generate a Room with four additional blocks if all wings are true" in {
    TestAtrium(Seq(true, true, true, true)).voxels.size shouldBe Room().voxels.size + 4
  }

  it should "generate a room with three additional blocks if three wings are true" in {
    TestAtrium(Seq(false, true, true, true)).voxels.size shouldBe Room().voxels.size + 3
  }

  it should "add the wings to the room" in {
    TestAtrium(Seq(true, false, true, false)) shouldBe (
      Room() ++ TestAtrium.actualWings(Seq(true, false, true, false)))
  }

  it should "add different wings to the room" in {
    TestAtrium(Seq(true, true, false, false)) shouldBe (
      Room() ++ TestAtrium.actualWings(Seq(true, true, false, false)))
  }

  it should "generate a null structure in the null case" in {
    NullAtrium() shouldBe Structure()
  }

  it should "generate only wings if there is no center structure" in {
    WingsOnlyAtrium(Seq.fill(4)(true)).voxels.size shouldBe 8
  }

  object NullAtrium extends Atrium {
    override val wingStructure: Structure = Structure()
    override val centerStructure: Structure = Structure()
  }

  object WingsOnlyAtrium extends Atrium {
    override val wingStructure: Structure = testWing
    override val centerStructure: Structure = Structure()
  }
}
