package com.recon419a.verticality


import org.scalatest.FlatSpec
import org.scalatest.Matchers


class StructureTest extends FlatSpec with Matchers {
  "contains" should "return true for a value in the box" in {
    StructureDummy.contains(Coordinate(2, 2, 2)) shouldBe true
  }

  it should "return false for a value less than the box in all dimensions" in {
    StructureDummy.contains(Coordinate(-1, -1, -1)) shouldBe false
  }

  it should "return false for a value greater than the box in one dimension" in {
    StructureDummy.contains(Coordinate(2, 2, 5)) shouldBe false
  }

  it should "return true for a value along the lesser wall" in {
    StructureDummy.contains(Coordinate(2, 0, 2)) shouldBe true
  }

  it should "return true for the greatest value in the box" in {
    StructureDummy.contains(Coordinate(4, 4, 4)) shouldBe true
  }

  it should "return true for the least value in the box" in {
    StructureDummy.contains(Coordinate(0, 0, 0)) shouldBe true
  }

  object StructureDummy extends Structure {
    override def voxel: Coordinate => Option[Voxel] = ???

    override val maxCoordinate: Coordinate = Coordinate(4, 4, 4)

    override def offset: Coordinate = ORIGIN
  }
}
