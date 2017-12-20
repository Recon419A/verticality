package com.recon419a.verticality.structures.cuboids

import com.recon419a.verticality.util.Coordinate
import com.recon419a.verticality.util.Constants.ORIGIN

class CustomFilledCuboid(val maxCoordinate: Coordinate, val offset: Coordinate) extends FilledCuboid

object CustomFilledCuboid {
  def apply(maxCoordinate: Coordinate, offset: Coordinate): CustomFilledCuboid = {
    new CustomFilledCuboid(maxCoordinate, offset)
  }

  def apply(width: Int, height: Int, depth: Int, offset: Coordinate): CustomFilledCuboid = {
    apply(Coordinate(width - 1, height - 1, depth - 1), offset)
  }

  def apply(width: Int, height: Int, offset: Coordinate): CustomFilledCuboid = {
    apply(width, height, 1, offset)
  }

  def apply(width: Int, height: Int, depth: Int): CustomFilledCuboid = {
    apply(width, height, depth, ORIGIN)
  }

  def apply(width: Int, height: Int): CustomFilledCuboid = {
    apply(width, height, 1)
  }
}
