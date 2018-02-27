package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

object StalkedClover extends Structure {
  def apply(wingFlags: WingFlags, existingStructure: Structure = Structure()): Structure = {
    Clover(wingFlags, (existingStructure + GridCoordinate(0, 0, 1)) + Hallway()) + GridCoordinate(0, 0, 1) + Hallway()
  }
}
