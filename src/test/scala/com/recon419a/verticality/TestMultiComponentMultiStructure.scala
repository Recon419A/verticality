package com.recon419a.verticality

object TestMultiComponentMultiStructure extends MultiStructure {
  override val components: List[Structure] = List(TestOriginStructure, TestOffsetStructure)

  /**
    * The outermost corner (inclusive) of a bounding box starting at the origin. Defined as a function instead of a
    * value because it may be dynamically calculated for structures with random sizes.
    *
    * @return the coordinate in an origin-based bounding box which is greatest in all dimensions
    */
  override def maxCoordinate: Coordinate = Coordinate(1, 2, 2)

  /**
    * The offset of a structure's bounding box from the origin, measured to the minimum of each dimension. Defined as
    * a function instead of a value to allow for random or patterned placement of structures.
    *
    * @return the coordinate in a translated bounding box which is least in all dimensions
    */
  override def offset: Coordinate = ORIGIN
}