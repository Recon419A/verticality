package com.recon419a.verticality.structures.doors

import com.recon419a.verticality.Coordinate

class CustomDoor(val maxCoordinate: Coordinate, val offset: Coordinate) extends Door

object CustomDoor {
  def apply(maxCoordinate: Coordinate, offset: Coordinate): CustomDoor = {
    new CustomDoor(maxCoordinate, offset)
  }

  def apply(width: Int, height: Int, depth: Int, offset: Coordinate): CustomDoor = {
    apply(Coordinate(width - 1, height - 1, depth - 1), offset)
  }

  def apply(width: Int, height: Int, offset: Coordinate): CustomDoor = {
    apply(width, height, 1, offset)
  }
}