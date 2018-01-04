package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class HallwayTest extends FlatSpec with Matchers {
  "apply" should "create a hallway with correct corners and hollow center" in {
    Hallway().voxels should contain allOf(Voxel(3, 0, 0), Voxel(7, 4, 10))
    Hallway().voxels should contain allOf(Voxel(4, 1, 0, SimpleBlock.AIR), Voxel(6, 3, 10, SimpleBlock.AIR))
  }

  it should "allow for non-default materials" in {
    Hallway(SimpleBlock.ACACIA_FENCE).voxels.map(_.block) shouldBe Set(SimpleBlock.ACACIA_FENCE, SimpleBlock.GLOWSTONE,
      SimpleBlock.AIR)
  }
}
