package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

import scala.util.Random

object OpenAtrium {
  def apply(): Structure = {
    val north = potentialRandomStructure(Hallway().rotateFlip + GridCoordinate(0, 0, -1))
    val east = potentialRandomStructure(Hallway().rotateCounterClockwise + GridCoordinate(1, 0))
    val south = potentialRandomStructure(Hallway() + GridCoordinate(0, 0, 1))
    val west = potentialRandomStructure(Hallway().rotateClockwise + GridCoordinate(-1, 0))
    val wings = List(north, east, south, west).flatten
    Room() ++ wings
  }

  private def potentialRandomStructure(westFacingHallway: Structure): Option[Structure] = {
    if (Random.nextBoolean()) {
      Some(westFacingHallway)
    } else None
  }
}
