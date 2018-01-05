package com.recon419a.verticality.structures

import scala.util.Random

case class WingFlags(north: Boolean = false, east: Boolean = false, south: Boolean = false, west: Boolean = false)
  extends Seq[Boolean] {
  override def length: Int = 4

  override def iterator: Iterator[Boolean] = {
    Seq(north, east, south, west).iterator
  }

  def apply(idx: Int): Boolean = {
    Seq(north, east, south, west)(idx)
  }

  def &&(that: WingFlags): WingFlags = {
    this.zip(that).map({ case (a, b) => a && b })
  }
}

object WingFlags {
  def random(): WingFlags = {
    WingFlags(Random.nextBoolean(), Random.nextBoolean(), Random.nextBoolean(), Random.nextBoolean())
  }

  implicit def apply(wingFlags: Seq[Boolean]): WingFlags = {
    assert(wingFlags.lengthCompare(4) == 0)
    WingFlags(wingFlags.head, wingFlags(1), wingFlags(2), wingFlags(3))
  }
}
