package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Voxel
import org.scalatest.{FlatSpec, Matchers}

class PatioTest extends FlatSpec with Matchers {
  "apply" should "create a structure two high" in {
    Patio().maxCoordinate.y shouldBe 1
  }

  it should "create a structure with no voxels on the first layer" in {
    Patio().voxels.filter(_.coordinate.y == 0) shouldBe Set.empty[Voxel]
  }
}
