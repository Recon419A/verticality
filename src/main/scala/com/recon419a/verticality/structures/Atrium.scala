package com.recon419a.verticality.structures

import com.recon419a.verticality.util.GridCoordinate

import scala.util.Random

trait Atrium {
  val structure: Structure

  def apply(wingFlags: Seq[Boolean] = Seq.fill(4)(Random.nextBoolean())): Structure = {
    Room() ++ actualWings(wingFlags)
  }

  def actualWings(wingFlags: Seq[Boolean]): List[Structure] = {
    potentialWings.zip(wingFlags).collect {
      case (wing, flag) if flag => wing
    }
  }

  def potentialWings: List[Structure] = {
    val northWing = structure.rotateFlip + GridCoordinate(0, 0, -1)
    val eastWing = structure.rotateCounterClockwise + GridCoordinate(1, 0)
    val southWing = structure + GridCoordinate(0, 0, 1)
    val westWing = structure.rotateClockwise + GridCoordinate(-1, 0)
    List(northWing, eastWing, southWing, westWing)
  }
}
