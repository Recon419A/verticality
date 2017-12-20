package com.recon419a.verticality.structures

import com.recon419a.verticality.util.Coordinate
import com.recon419a.verticality.util.Constants.ORIGIN

class OffsetRoom(val offset: Coordinate) extends MultiStructure {
  override val components: List[Structure] = List(BasicRoom(ORIGIN), BasicRoom(Coordinate(4, 0, 4)))

  /**
    * The outermost corner (inclusive) of a bounding box starting at the origin. Defined as a function instead of a
    * value because it may be dynamically calculated for structures with random sizes.
    *
    * @return the coordinate in an origin-based bounding box which is greatest in all dimensions
    */
  override def maxCoordinate: Coordinate = Coordinate(12, 8, 12)
}

object OffsetRoom {
  def apply(offset: Coordinate): OffsetRoom = {
    new OffsetRoom(offset)
  }
}
