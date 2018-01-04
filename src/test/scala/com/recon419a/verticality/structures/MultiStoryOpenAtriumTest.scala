package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{GridCoordinate, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryOpenAtriumTest extends FlatSpec with Matchers {
  val testFullWingOpenAtrium = TestFullWingOpenAtrium() // Initialize once for efficiency

  "atrium" should "be an open atrium" in {
    MultiStoryOpenAtrium.atrium shouldBe OpenAtrium
  }

  "apply" should "create a room between (-1, 0, -1) and (2, 2, 2) for all true flags" in {
    testFullWingOpenAtrium.maxCoordinate shouldBe GridCoordinate(2, 2, 2)
    testFullWingOpenAtrium.minCoordinate shouldBe GridCoordinate(-1, 0, -1)
  }

  it should "create a room with lighting in lower hallways" in {
    testFullWingOpenAtrium.voxels
      .filter(_.coordinate.y == 4).filter(_.block == SimpleBlock.GLOWSTONE) should not be Set.empty[Voxel]
  }

  object TestFullWingOpenAtrium {
    def apply(): Structure = {
      val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(true))
      MultiStoryOpenAtrium(wingFlags)
    }
  }
}
