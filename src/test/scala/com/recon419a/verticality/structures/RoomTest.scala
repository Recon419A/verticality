package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class RoomTest extends FlatSpec with Matchers {
  "apply" should "create a room with correct min and max corners" in {
    Room().voxels should contain allOf(Voxel(0, 0, 0), Voxel(10, 4, 10))
    Room().voxels should contain allOf(Voxel(1, 1, 1, SimpleBlock.AIR), Voxel(9, 3, 9, SimpleBlock.AIR))
  }
}
