package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}
import com.recon419a.verticality.util.Constants.ORIGIN
import net.morbz.minecraft.world.World

trait Structure {
  /**
    * The outermost corner (inclusive) of a bounding box starting at the origin. Defined as a function instead of a
    * value because it may be dynamically calculated for structures with random sizes.
    *
    * @return the coordinate in an origin-based bounding box which is greatest in all dimensions
    */
  def maxCoordinate: Coordinate

  /**
    * The offset of a structure's bounding box from the origin, measured to the minimum of each dimension. Defined as
    * a function instead of a value to allow for random or patterned placement of structures.
    *
    * @return the coordinate in a translated bounding box which is least in all dimensions
    */
  def offset: Coordinate

  /**
    * A function defining the structure in a procedural manner. Defined as a function instead of a value to allow for
    * procedurally generated structures. Returns Option[Voxel] so that None may be used to indicate the structure
    * doesn't care about that location; this is useful for overlapping multiple structures together. Assumes that the
    * structure's bounding box begins at the origin and extends as far as maxCoordinate.
    *
    * @return a function mapping from coordinates to voxels
    */
  def voxel: Coordinate => Option[Voxel]

  /**
    * A function defining the translation of the voxels in a procedural manner. Represents the origin-based voxels
    * translated by offset, or the "real location" of the object after translation.
    *
    * @return a function mapping from coordinates to voxels, translated by offset
    */
  def translatedVoxel: Coordinate => Option[Voxel] = {
    { coordinate => voxel(coordinate - offset).map(_.translate(offset)) }
  }

  /**
    * All the relevant voxels to this object's origin-based pattern, baked out as a list. If the function defining
    * this origin-based pattern is non-deterministic, this function will also be non-deterministic.
    *
    * @return a list of voxels representing this structure, located between the origin and maxCoordinate
    */
  def voxelList: List[Voxel] = {
    (ORIGIN to maxCoordinate).map(voxel).flatten
  }

  /**
    * All the relevant voxels to this object's translated pattern, represented as a list. If the function defining
    * this pattern is non-deterministic, this function will also be non-deterministic.
    *
    * @return a list of voxels representing this structure, located between offset and offset + maxCoordinate
    */
  def translatedVoxelList: List[Voxel] = {
    voxelList.map(_.translate(offset))
  }

  /**
    * Render this structure to the provided world. This places the structure starting at offset and extending to
    * offset + maxCoordinate, and will cause the default generation of chunks containing the structure to be
    * overwritten - this can result in holes plunging into the void beneath the structure in all chunks it touches.
    *
    * @param world a World object to render to
    */
  def renderTo(world: World): Unit = {
    translatedVoxelList.foreach(_.renderTo(world))
  }

  /**
    * Determines whether the structure's translated bounding box contains a coordinate.
    *
    * @param c the coordinate to inspect
    * @return whether that coordinate lies within the translated bounding box of this structure
    */
  def contains(c: Coordinate): Boolean = {
    offset <= c && c <= (offset + maxCoordinate)
  }
}
