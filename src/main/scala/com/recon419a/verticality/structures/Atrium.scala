package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, GridCoordinate, Size}

object Atrium {
  def apply(): Structure = {
    Room() + (Igloo() + GridCoordinate(0, 0, 1))
  }
}
