package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class MultiStoryOpenAtriumTest extends FlatSpec with Matchers {
  "atrium" should "be an open atrium" in {
    MultiStoryOpenAtrium.atrium shouldBe OpenAtrium
  }

  "apply" should "create a room with lighting in lower hallways" in {
    val wingFlags: Seq[Seq[Boolean]] = Seq.fill(2)(Seq.fill(4)(true))
    MultiStoryOpenAtrium(wingFlags).voxels
      .filter(_.coordinate.y == 4).filter(_.block == SimpleBlock.GLOWSTONE) should not be Set.empty[Voxel]
  }
}
