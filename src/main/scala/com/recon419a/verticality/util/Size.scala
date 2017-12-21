package com.recon419a.verticality.util

case class Size (width: Int, height: Int, depth: Int = 1)

object Size {
  def apply(coordinate: Coordinate): Size = {
    Size(coordinate.x + 1, coordinate.y + 1, coordinate.z + 1)
  }
}