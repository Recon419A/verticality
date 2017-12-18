package com.recon419a.verticality.structures

import com.recon419a.verticality.Coordinate

object TestOriginStructure extends TestStructure {
  /**
    * The offset of a structure's bounding box from the origin, measured to the minimum of each dimension. Defined as
    * a function instead of a value to allow for random or patterned placement of structures.
    *
    * @return the coordinate in a translated bounding box which is least in all dimensions
    */
  override def offset: Coordinate = Coordinate(0, 0, 0)
}
