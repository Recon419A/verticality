package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.cuboids.HollowCuboid
import com.recon419a.verticality.util.Coordinate

class MultiStoryRoom(offset: Coordinate, height: Int) extends HollowCuboid(Coordinate(8, 4 * height, 8), offset)

object MultiStoryRoom {
  def apply(offset: Coordinate, height: Int): MultiStoryRoom = {
    new MultiStoryRoom(offset, height)
  }
}
