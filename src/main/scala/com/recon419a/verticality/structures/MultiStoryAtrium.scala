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
    floors.reduce((s1, s2) => s2 + s1)
  }

  def floorFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
    Seq(Seq.fill(wingFlags.head.size)(false)) ++ wingFlags
  }

  def ceilingFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
    wingFlags ++ Seq(Seq.fill(wingFlags.head.size)(false))
  }
}
