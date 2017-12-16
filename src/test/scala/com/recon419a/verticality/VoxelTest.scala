package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

class VoxelTest extends FlatSpec with Matchers with MockitoSugar {
  "offset" should "offset along the correct axes" in {
    Voxel(Coordinate(1, 2, 3), DEFAULT_MATERIAL).translate(Coordinate(4, 5, 6)) shouldBe
      Voxel(Coordinate(5, 7, 9), DEFAULT_MATERIAL)
  }

  it should "work for negative values" in {
    Voxel(Coordinate(1, 2, 3), DEFAULT_MATERIAL).translate(Coordinate(5, -3, 4)) shouldBe
      Voxel(Coordinate(6, -1, 7), DEFAULT_MATERIAL)
  }

  it should "work for non-default materials" in {
    Voxel(Coordinate(1, 1, 1), SimpleBlock.BRICK_BLOCK).translate(Coordinate(1, 2, 3)) shouldBe
      Voxel(Coordinate(2, 3, 4), SimpleBlock.BRICK_BLOCK)
  }

  "renderTo" should "call World.setBlock with the correct arguments" in {
    val mockWorld = mock[World]
    Voxel(Coordinate(0, 1, -4), DEFAULT_MATERIAL).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, -4, DEFAULT_MATERIAL)
  }

  it should "work for non-default materials" in {
    val mockWorld = mock[World]
    Voxel(Coordinate(0, 1, -4), SimpleBlock.ACACIA_FENCE).renderTo(mockWorld)
    verify(mockWorld).setBlock(0, 1, -4, SimpleBlock.ACACIA_FENCE)
  }

  private def makeWorld = {
    val layers = new DefaultLayers
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(0, 0, 0)
    new World(level, layers)
  }
}
