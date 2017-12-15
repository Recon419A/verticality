package com.recon419a.verticality

import org.scalatest.{FlatSpec, Matchers}

class MultiStructureTest extends FlatSpec with Matchers {
  "voxel" should "return the values for a single structure when only one exists" in {
    new TestMultiStructure(new StructureDummy)
  }

  class TestMultiStructure(override val components: List[Structure],
                           override val maxCoordinate: Coordinate,
                           override val offset: Coordinate) extends MultiStructure
}
