package com.recon419a.verticality.structures.doors

import com.recon419a.verticality.{Coordinate, Structure}

object CenteredDoor {
  def apply(maxCoordinate: Coordinate, structure: Structure): CustomDoor = {
    val relativeOffset = (structure.maxCoordinate / 2) - (maxCoordinate / 2)
    val axisSnappedRelativeOffset = Coordinate(relativeOffset.x, relativeOffset.y, 0)
    CustomDoor(maxCoordinate, structure.offset + axisSnappedRelativeOffset)
  }

  def apply(height: Int, width: Int, depth: Int, structure: Structure): CustomDoor = {
    apply(Coordinate(height - 1, width - 1, depth - 1), structure)
  }

  def apply(height: Int, width: Int, structure: Structure): CustomDoor = {
    apply(height, width, 1, structure)
  }
}