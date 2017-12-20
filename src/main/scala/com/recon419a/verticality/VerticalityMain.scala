package com.recon419a.verticality

import com.recon419a.verticality.structures.{Cuboid, Hallway}
import com.recon419a.verticality.util.Coordinate
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld

  makeFloor()

  (Hallway(5, 5, 8) + Coordinate(0, 10)).renderTo(world)

  private def makeFloor(): Unit = {
    (Cuboid(50, 1, 50) + Coordinate(-25, 0, -25)).renderTo(world)
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
