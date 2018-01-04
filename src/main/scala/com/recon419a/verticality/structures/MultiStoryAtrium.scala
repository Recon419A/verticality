package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

import scala.util.Random

trait MultiStoryAtrium {
  val atrium: Atrium

  def apply(numFloors: Int): Structure = {
    apply(Seq.fill(numFloors)(Seq.fill(4)(Random.nextBoolean())))
  }

  def apply(wingFlags: Seq[Seq[Boolean]]): Structure = {
    val floors = wingFlags.indices.map(i => atrium(wingFlags(i)) + GridCoordinate(0, i))
    val floorRemovers = wingFlags.indices.dropRight(1).map(i => CeilingDeleter() + GridCoordinate(0, i))
    floors.reduce((s1, s2) => s1 + s2) + floorRemovers.reduce((s1, s2) => s1 + s2)
  }
}
