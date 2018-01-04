package com.recon419a.verticality.structures

import com.recon419a.verticality.util._
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryAtriumTest extends FlatSpec with Matchers {
  "apply" should "create a 1x2x1 room for all false flags" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(false))
    TestMultiStoryAtrium(wingFlags).maxCoordinate shouldBe GridCoordinate(1, 2, 1)
  }

  it should "create a room with a one wing for one true flag" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq(Seq(true, false, false, false), Seq.fill(4)(false))
    (TestMultiStoryAtrium(wingFlags) - Cuboid(GridSize(1, 2))).voxels.size shouldBe 1
  }

  it should "create a room with a south bottom wing for a south bottom true flag" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq(Seq(false, false, true, false), Seq.fill(4)(false))
    (TestMultiStoryAtrium(wingFlags) - Cuboid(GridSize(1, 2))).voxels.head shouldBe Voxel(0, 0, 11)
  }

  it should "create a room with a north top wing for a north top true flag" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq(Seq.fill(4)(false), Seq(true, false, false, false))
    (TestMultiStoryAtrium(wingFlags) - Cuboid(GridSize(1, 2))).voxels.head shouldBe Voxel(10, 4, -1)
  }

  it should "create a room with no floor in the middle" in {
    TestMultiStoryAtrium(2).voxels should contain noneOf(Voxel(4, 4, 4), Voxel(5, 4, 7))
  }

  it should "create an atrium given a single floor" in {
    val wingFlags = Seq(true, false, false, true)
    TestMultiStoryAtrium(Seq(wingFlags)) shouldBe TestAtrium(wingFlags)
  }

  object TestMultiStoryAtrium extends MultiStoryAtrium {
    val atrium: TestAtrium.type = TestAtrium
  }
}
