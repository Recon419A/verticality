package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{GridCoordinate, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryClosedAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be a closed atrium" in {
    MultiStoryClosedAtrium.atrium shouldBe ClosedAtrium
  }

  "apply" should "create a room with maximum GridCoordinate (3, 2, 3) for all true flags" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(true))
    MultiStoryClosedAtrium(wingFlags).maxCoordinate shouldBe GridCoordinate(3, 2, 3)
  }

  it should "create a room with minimum GridCoordinate (-2, 0, -2) for all true flags" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(true))
    MultiStoryClosedAtrium(wingFlags).minCoordinate shouldBe GridCoordinate(-2, 0, -2)
  }

  it should "create a room with lighting in lower hallways" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(true))
    MultiStoryClosedAtrium(wingFlags).voxels
      .filter(_.coordinate.y == 4).filter(_.block == SimpleBlock.GLOWSTONE) should not be Set.empty[Voxel]
  }
}
