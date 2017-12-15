package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld

  // Make a floor for spawning on
  FilledCuboid(Coordinate(100, 3, 100), Coordinate(-50, 0, -50)).renderTo(world)

//  private val basicRoom = HollowCuboid(Coordinate(8, 4, 8))
  val room1 = BasicRoom
  val room2 = BasicRoom
  val offset = Coordinate(4, 0, 4)

  BasicRoom.renderTo(world)
  BasicRoom.renderTo(world)


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
