package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{GridCoordinate, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class IglooTest extends FlatSpec with Matchers {
  "apply" should "create a structure that contains all the voxels of a hallway" in {
    Hallway().voxels.diff(Igloo().voxels) shouldBe Set.empty[Voxel]
  }

  it should "create a structure that is missing nine voxels for the door" in {
    (Room() + GridCoordinate(0, 0, 1)).voxels.diff(Igloo().voxels).size shouldBe 9
  }

  it should "create a structure that is 1x1x2 in grid coordinates" in {
    Igloo().maxCoordinate shouldBe GridCoordinate(1, 1, 2)
  }

  it should "allow for use of non-default materials" in {
    Igloo(SimpleBlock.ACACIA_FENCE).voxels.map(_.block) shouldBe Set(SimpleBlock.ACACIA_FENCE, SimpleBlock.GLOWSTONE,
      SimpleBlock.AIR)
  }
}
