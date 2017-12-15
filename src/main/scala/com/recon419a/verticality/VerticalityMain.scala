package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld
  val floor = FilledCuboid(Coordinate(-100, 0, -100), Coordinate(100, 4, 100), SimpleBlock.BEDROCK)
  private val basicRoom = HollowCuboid(Coordinate(-4, 0, -4), Coordinate(4, 4, 4), SimpleBlock.MOSSY_COBBLESTONE)
  basicRoom.renderTo(world, Coordinate(0, 10, 0))
  basicRoom.renderTo(world, Coordinate(4, 10, 4))


  private def makeWorld = {
    val layers = new DefaultLayers
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(0, 0, 0)
    new World(level, layers)
  }

  // Everything's set up so we're going to save the world.
  world.save()
}
