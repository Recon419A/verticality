package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

import scala.util.Random

trait Atrium {
  val wingStructure: Structure
  val centerStructure: Structure

  def apply(wingFlags: Seq[Boolean] = Seq.fill(4)(Random.nextBoolean())): Structure = {
    centerStructure ++ actualWings(wingFlags)
  }

  def actualWings(wingFlags: Seq[Boolean]): List[Structure] = {
    potentialWings.zip(wingFlags).collect {
      case (wing, flag) if flag => wing
    }
  }

  def potentialWings: List[Structure] = {
    val northWing = wingStructure.rotateFlip + GridCoordinate(0, 0, -1)
    val eastWing = wingStructure.rotateCounterClockwise + GridCoordinate(1, 0)
    val southWing = wingStructure + GridCoordinate(0, 0, 1)
    val westWing = wingStructure.rotateClockwise + GridCoordinate(-1, 0)
    List(northWing, eastWing, southWing, westWing)
  }
}
