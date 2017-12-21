package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}
import net.morbz.minecraft.blocks.SimpleBlock

object Igloo {
  def apply(roomSize: Size, hallwaySize: Size): Structure = {
    ((Room(roomSize) + roomZOffset(hallwaySize))
      + (Hallway(hallwaySize) + hallwayXOffset(roomSize, hallwaySize))
      - (Cuboid(innerSize(hallwaySize).copy(depth = 1)) + doorOffset(roomSize, hallwaySize)))
  }

  private def doorOffset(roomSize: Size, hallwaySize: Size) = {
    hallwayXOffset(roomSize, hallwaySize) + roomZOffset(hallwaySize) + Coordinate(1, 1)
  }

  private def innerSize(hallwaySize: Size): Size = {
    hallwaySize - Size(2, 2)
  }

  private def hallwayXOffset(roomSize: Size, hallwaySize: Size) = {
    (Coordinate(roomSize) / 2 - Coordinate(hallwaySize) / 2).copy(y = 0, z = 0)
  }

  private def roomZOffset(hallwaySize: Size) = {
    Coordinate(hallwaySize).copy(x = 0, y = 0) + Coordinate(0, 0, 1)
  }
}
