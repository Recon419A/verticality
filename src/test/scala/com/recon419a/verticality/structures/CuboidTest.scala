package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class CuboidTest extends FlatSpec with Matchers {

  "apply" should "correctly generate a single block at the origin" in {
    Cuboid(Size(1, 1)).voxels shouldBe Set(Voxel(0, 0))
  }

  it should "correctly generate a 2x1 pillar" in {
    Cuboid(Size(2, 1)).voxels shouldBe Set(Voxel(0, 0), Voxel(1, 0))
  }

  it should "correctly generate a 1x2x3 cuboid" in {
    Cuboid(Size(1, 2, 3)).voxels shouldBe Set(Voxel(0, 0, 0), Voxel(0, 0, 1), Voxel(0, 0, 2), Voxel(0, 1, 0), Voxel(0, 1, 1),
      Voxel(0, 1, 2))
  }

  it should "use the default material if one is not provided" in {
    Cuboid(Size(1, 1)).voxels shouldBe Set(Voxel(0, 0, DEFAULT_BLOCK))
  }

  it should "work for non-default materials with a size argument" in {
    Cuboid(Size(1, 1), SimpleBlock.ACACIA_FENCE).voxels shouldBe Set(Voxel(0, 0, SimpleBlock.ACACIA_FENCE))
  }
}
