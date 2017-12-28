package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Size, Voxel}
import org.scalatest.{FlatSpec, Matchers}

class IglooTest extends FlatSpec with Matchers {
  "apply" should "create a 3x3x4 dead end from a 3x3x3 room and a 3x3x1 hallway" in {
    val testIgloo = Igloo(Size(3, 3, 3), Size(3, 3))
    testIgloo.voxels.size shouldBe 33
    testIgloo.voxels should contain noneOf (Voxel(1, 1, 0), Voxel(1, 1, 1), Voxel(1, 1, 2))
    testIgloo.voxels should contain allOf (Voxel(1, 1, 3), Voxel(1, 2, 3), Voxel(0, 0, 0))
  }
}
