package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Size}

object Step {
  def apply(): Structure = {
    Cuboid(Size(3, 1)) + Coordinate(4, 0, -1)
  }
}
