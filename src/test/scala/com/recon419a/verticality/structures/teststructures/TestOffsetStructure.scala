package com.recon419a.verticality.structures.teststructures

import com.recon419a.verticality.util.Coordinate

object TestOffsetStructure extends TestStructure {
  /**
    * The offset of a structure's bounding box from the origin, measured to the minimum of each dimension. Defined as
    * a function instead of a value to allow for random or patterned placement of structures.
    *
    * @return the coordinate in a translated bounding box which is least in all dimensions
    */
  override def offset: Coordinate = Coordinate(0, 1, 1)
}
