package com.recon419a.verticality

import net.morbz.minecraft.blocks.SimpleBlock

trait TestStructure extends Structure {
  /**
    * The outermost corner (inclusive) of a bounding box starting at the origin. Defined as a function instead of a
    * value because it may be dynamically calculated for structures with random sizes.
    *
    * @return the coordinate in an origin-based bounding box which is greatest in all dimensions
    */
  override def maxCoordinate: Coordinate = Coordinate(1, 1, 1)

  /**
    * A function defining the structure in a procedural manner. Defined as a function instead of a value to allow for
    * procedurally generated structures. Returns Option[Voxel] so that None may be used to indicate the structure
    * doesn't care about that location; this is useful for overlapping multiple structures together. Assumes that the
    * structure's bounding box begins at the origin and extends as far as maxCoordinate.
    *
    * @return a function mapping from coordinates to voxels
    */
  override def voxel: Coordinate => Option[Voxel] = {
    Map(Coordinate(0, 0, 0) -> Some(Voxel(Coordinate(0, 0, 0), SimpleBlock.BRICK_BLOCK)),
      Coordinate(0, 0, 1) -> Some(Voxel(Coordinate(0, 0, 1), SimpleBlock.BOOKSHELF)),
      Coordinate(0, 1, 0) -> Some(Voxel(Coordinate(0, 1, 0), SimpleBlock.CLAY)),
      Coordinate(0, 1, 1) -> None,
      Coordinate(1, 0, 0) -> Some(Voxel(Coordinate(1, 0, 0), SimpleBlock.COAL_BLOCK)),
      Coordinate(1, 0, 1) -> None,
      Coordinate(1, 1, 0) -> Some(Voxel(Coordinate(1, 1, 0), SimpleBlock.COBBLESTONE)),
      Coordinate(1, 1, 1) -> None).withDefaultValue(None)
  }
}
