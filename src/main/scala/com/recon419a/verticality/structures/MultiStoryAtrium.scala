package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

trait MultiStoryAtrium {
  val atrium: Atrium

  def apply(numFloors: Int, existingStructure: Structure): Structure = {
    apply(Seq.fill(numFloors)(WingFlags.random()), existingStructure)
  }

  def apply(wingFlags: Seq[WingFlags], existingStructure: Structure = Structure()): Structure = {
    val floors = wingFlags.indices.map(i => atrium(wingFlags(i), existingStructure) + GridCoordinate(0, i))
    floors.reduce((s1, s2) => s2 + s1)
  }
}
