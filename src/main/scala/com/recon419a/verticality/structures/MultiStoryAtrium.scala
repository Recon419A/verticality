package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

trait MultiStoryAtrium {
  val atrium: Atrium

  def apply(numFloors: Int): Structure = {
    apply(Seq.fill(numFloors)(WingFlags.random()))
  }

  def apply(wingFlags: Seq[WingFlags]): Structure = {
    val floors = wingFlags.indices.map(i => atrium(wingFlags(i)) + GridCoordinate(0, i))
    floors.reduce((s1, s2) => s2 + s1)
  }
}
