package com.recon419a.verticality.structures.teststructures

import com.recon419a.verticality.util.Constants.ORIGIN
import com.recon419a.verticality.structures.Structure
import com.recon419a.verticality.util.{Coordinate, Voxel}
import net.morbz.minecraft.blocks.SimpleBlock

object TestAtomicStructure extends Structure {
  /**
    * The outermost corner (inclusive) of a bounding box starting at the origin. Defined as a function instead of a
    * value because it may be dynamically calculated for structures with random sizes.
    *
    * @return the coordinate in an origin-based bounding box which is greatest in all dimensions
    */
  override def maxCoordinate: Coordinate = ORIGIN

  /**
    * The offset of a structure's bounding box from the origin, measured to the minimum of each dimension. Defined as
    * a function instead of a value to allow for random or patterned placement of structures.
    *
    * @return the coordinate in a translated bounding box which is least in all dimensions
    */
  override def offset: Coordinate = ORIGIN

  /**
    * A function defining the structure in a procedural manner. Defined as a function instead of a value to allow for
    * procedurally generated structures. Returns Option[Voxel] so that None may be used to indicate the structure
    * doesn't care about that location; this is useful for overlapping multiple structures together. Assumes that the
    * structure's bounding box begins at the origin and extends as far as maxCoordinate.
    *
    * @return a function mapping from coordinates to voxels
    */
  override def voxel: Coordinate => Option[Voxel] = Map(
    Coordinate(0, 0, 0) -> Some(Voxel(Coordinate(0, 0, 0), SimpleBlock.DIAMOND_BLOCK))
  ).withDefaultValue(None)
}
