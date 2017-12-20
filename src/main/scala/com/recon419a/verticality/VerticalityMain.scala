package com.recon419a.verticality

import com.recon419a.verticality.structures._
import com.recon419a.verticality.structures.cuboids.CustomFilledCuboid
import com.recon419a.verticality.util.Coordinate
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld

  // Make a floor for spawning on
  CustomFilledCuboid(Coordinate(100, 0, 100), Coordinate(-50, 2, -50)).renderTo(world)

//  val test = MultiStoryRoom(Coordinate(0, 10, 0), 4)
  val test = OffsetRoom(Coordinate(0, 10, 0))
  test.renderTo(world)


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
