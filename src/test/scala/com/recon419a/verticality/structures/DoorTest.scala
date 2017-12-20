package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.doors.CenteredDoor
import com.recon419a.verticality.{Coordinate, ORIGIN, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import org.scalatest.{FlatSpec, Matchers}

class DoorTest extends FlatSpec with Matchers {
  "CenteredDoor" should "be located at (1, 1, 0) for a 1x1 door in a 3x3 wall" in {
    CenteredDoor(1, 1, CustomFilledCuboid(3, 3)).translatedVoxelList shouldBe
      List(Voxel(Coordinate(1, 1, 0), SimpleBlock.AIR))
  }

  ignore should "be located from (1, 1, 0) to (2, 2, 0) for a 2x2 door in a 4x4 wall" in {
    CenteredDoor(2, 2, CustomFilledCuboid(4, 4)).translatedVoxelList shouldBe None
  }
}
