package com.recon419a.verticality.structures

case class WingFlags(north: Boolean = false, east: Boolean = false, south: Boolean = false, west: Boolean = false)
  extends Seq[Boolean] {
  override def length: Int = 4

  override def iterator: Iterator[Boolean] = {
    Seq(north, east, south, west).iterator
  }

  def apply(idx: Int): Boolean = {
    Seq(north, east, south, west)(idx)
  }
}
