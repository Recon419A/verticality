package com.recon419a.verticality

import com.recon419a.verticality.structures._
import com.recon419a.verticality.util.{Coordinate, GridCoordinate, Size}
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld

  makeFloor()

  (Dungeon() + GridCoordinate(0, 2)).renderTo(world)

  private def makeFloor(): Unit = {
    (Cuboid(Size(50, 1, 50)) + Coordinate(-25, 0, -25)).renderTo(world)
  }

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
