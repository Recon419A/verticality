package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Coordinate

object MultiStoryClosedAtrium {
  def apply(): Structure = {
    ((ClosedAtrium() + CeilingDeleter()) + Coordinate(0, 4)) + ClosedAtrium()
  }
}
