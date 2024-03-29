package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate, Size, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World
import org.mockito.Mockito.verify
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class StructureTest extends FlatSpec with Matchers with MockitoSugar {
  "+" should "correctly translate a single voxel" in {
    (Cuboid(Size(1, 1)) + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3))
  }

  private val testCuboid1 = Cuboid(Size(2, 1))
  private val testCuboid2: Structure = Cuboid(Size(2, 1), SimpleBlock.ACACIA_FENCE) + Coordinate(1, 0)
  private val testOffsetPixel = Structure(Set(Voxel(5, 2, 5)))

  it should "correctly translate two voxels" in {
    (testCuboid1 + Coordinate(1, 2, 3)).voxels shouldBe Set(Voxel(1, 2, 3), Voxel(2, 2, 3))
  }

  it should "add two voxels together" in {
    (Cuboid(Size(1, 1)) + (Cuboid(Size(1, 1)) + Coordinate(1, 0))) shouldBe testCuboid1
  }

  it should "add two overlapping 2x1's together into a 3x1" in {
    (testCuboid1 + (testCuboid1 + Coordinate(1, 0))) shouldBe Cuboid(Size(3, 1))
  }

  it should "use materials from the second structure in case of conflict" in {
    (testCuboid1 + testCuboid2).voxel(1, 0, 0) shouldBe
      Some(Voxel(1, 0, 0, SimpleBlock.ACACIA_FENCE))
  }

  "++" should "cascade properly" in {
    val testCuboid3 = Cuboid(Size(2, 1), SimpleBlock.GRASS) + Coordinate(2, 0)
    (testCuboid1 ++ List(testCuboid2, testCuboid3)) shouldBe testCuboid1 + testCuboid2 + testCuboid3
  }

  "rotateCounterClockwise" should "rotate an 1x11 object into an 11x1 object" in {
    Cuboid(Size(11, 1)).rotateCounterClockwise shouldBe Cuboid(Size(1, 1, 11))
  }

  it should "rotate a centered object around the center of an 11x11 square" in {
    val testCuboid = Cuboid(Size(11, 1)) + Coordinate(0, 0, 4)
    testCuboid.rotateCounterClockwise shouldBe Cuboid(Size(1, 1, 11)) + Coordinate(4, 0)
  }

  it should "rotate an off-center object around the center of an 11x11 square" in {
    val testCuboid = Cuboid(Size(11, 1)) + Coordinate(0, 0, 5)
    testCuboid.rotateCounterClockwise shouldBe Cuboid(Size(1, 1, 11)) + Coordinate(5, 0)
  }

  it should "rotate the origin voxel appropriately" in {
    val testCuboid = Cuboid(Size(1, 1))
    testCuboid.rotateCounterClockwise shouldBe Cuboid(Size(1, 1)) + Coordinate(0, 0, 10)
  }

  it should "rotate a non-origin voxel appropriately" in {
    val testCuboid = Cuboid(Size(1, 1)) + Coordinate(1, 0, 1)
    testCuboid.rotateCounterClockwise shouldBe Cuboid(Size(1, 1)) + Coordinate(1, 0, 9)
  }

  "rotateFlip" should "invert itself" in {
    testCuboid1.rotateFlip.rotateFlip shouldBe testCuboid1
  }

  "rotateClockwise" should "invert rotateCounterClockwise" in {
    testCuboid1.rotateCounterClockwise.rotateClockwise shouldBe testCuboid1
  }

  "maxCoordinate" should "work for a simple cuboid" in {
    Cuboid(Size(1, 2, 3)).maxCoordinate shouldBe Coordinate(Size(1, 2, 3))
  }

  it should "take the highest dimensions for a non-cuboid structure" in {
    (Cuboid(Size(10, 1)) + Cuboid(Size(1, 10))).maxCoordinate shouldBe Coordinate(9, 9)
  }

  it should "work for a positively translated cuboid" in {
    (testCuboid1 + Coordinate(1, 2, 3)).maxCoordinate shouldBe Coordinate(2, 2, 3)
  }

  it should "work for a negatively translated single voxel" in {
    (Cuboid(Size(1, 1)) + Coordinate(-1, -2, -3)).maxCoordinate shouldBe Coordinate(-1, -2, -3)
  }

  it should "work for a negatively translated cuboid" in {
    (testCuboid1 + Coordinate(-1, -2, -3)).maxCoordinate shouldBe Coordinate(-1, -2, -3) + Coordinate(Size(2, 1))
  }

  "minCoordinate" should "be (0, 0, 0) for an un-translated cuboid" in {
    testCuboid1.minCoordinate shouldBe Coordinate(0, 0)
  }

  it should "be the translation for a negatively translated cuboid" in {
    (testCuboid1 + Coordinate(-5, -7, -8)).minCoordinate shouldBe Coordinate(-5, -7, -8)
  }

  it should "be the translation for a positively translated cuboid" in {
    (testCuboid1 + Coordinate(5, 8, 13)).minCoordinate shouldBe Coordinate(5, 8, 13)
  }

  it should "be the translation for a cuboid of mixed positives and negatives" in {
    (testCuboid1 + Coordinate(5, -3, 17)).minCoordinate shouldBe Coordinate(5, -3, 17)
  }

  it should "be the minimum of a bounding box for a rotated L-shape" in {
    ((testCuboid1 + GridCoordinate(-1, 0)) + (testCuboid1 + GridCoordinate(0, -1)))
      .minCoordinate shouldBe GridCoordinate(-1, -1)
  }

  "occupied" should "return true for an occupied cell" in {
    testCuboid1.occupied(Coordinate(1, 0)) shouldBe true
  }

  it should "return false for an unoccupied cell" in {
    testCuboid1.occupied(Coordinate(10, 0)) shouldBe false
  }

  "gridOccupied" should "return true for an occupied grid cell" in {
    testOffsetPixel.gridOccupied(GridCoordinate(0, 0)) shouldBe true
  }

  it should "return false for an unoccupied grid cell" in {
    testOffsetPixel.gridOccupied(GridCoordinate(1, 0)) shouldBe false
  }

  "collides" should "return true for the same structure" in {
    testCuboid1.collides(testCuboid1) shouldBe true
  }

  it should "return false for a non-overlapping structure" in {
    testCuboid1.collides(testOffsetPixel) shouldBe false
  }

  "renderTo" should "call setBlock with the correct arguments" in {
    val mockWorld = mock[World]
    Structure(Set(Voxel(0, 1, 2), Voxel(3, 4, 8, SimpleBlock.ACACIA_FENCE))).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, 2, DEFAULT_BLOCK)
    verify(mockWorld).setBlock(3, 4, 8, SimpleBlock.ACACIA_FENCE)
  }

  "apply" should "have no voxels by default" in {
    Structure().voxels shouldBe Set.empty[Voxel]
  }
}
