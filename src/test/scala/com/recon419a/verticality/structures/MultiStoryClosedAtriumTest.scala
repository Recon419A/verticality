package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{GridCoordinate, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryClosedAtriumTest extends FlatSpec with Matchers {
  val testFullWingClosedAtrium = TestFullWingClosedAtrium()

  "atrium" should "be a closed atrium" in {
    MultiStoryClosedAtrium.atrium shouldBe ClosedAtrium
  }

  "apply" should "create a room between (-2, 0, -2) and (3, 2, 3) for all true flags" in {
    testFullWingClosedAtrium.maxCoordinate shouldBe GridCoordinate(3, 2, 3)
    testFullWingClosedAtrium.minCoordinate shouldBe GridCoordinate(-2, 0, -2)
  }

  it should "create a room with lighting in lower hallways" in {
    testFullWingClosedAtrium.voxels
      .filter(_.coordinate.y == 4).filter(_.block == SimpleBlock.GLOWSTONE) should not be Set.empty[Voxel]
  }

  it should "create a room with no floor in the middle except bridges" in {
    testFullWingClosedAtrium.voxels should contain noneOf(Voxel(2, 4, 2), Voxel(7, 4, 7))
  }

  object TestFullWingClosedAtrium {
    def apply(): Structure = {
      val wingFlags: Seq[WingFlags] = Seq.fill(2)(Seq.fill(4)(true))
      MultiStoryClosedAtrium(wingFlags)
    }
  }
}
