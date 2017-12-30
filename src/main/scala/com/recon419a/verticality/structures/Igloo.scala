package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

object Igloo {
  def apply(): Structure = {
    (Room() + GridCoordinate(0, 0, 1)) + Hallway()
  }
}
