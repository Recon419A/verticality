package com.recon419a.verticality

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
    * procedurally generated structures.
    *
    * @return a function mapping from coordinates to voxels
    */
  def voxels: Coordinate => Option[Voxel]

  /**
    * Render this structure to the provided world. This places the structure starting at offset and extending to
    * offset + maxCoordinate, and will cause the default generation of chunks containing the structure to be
    * overwritten - this can result in holes plunging into the void beneath the structure in all chunks it touches.
    *
    * @param world a World object to render to
    */
  def renderTo(world: World): Unit = {
    val coordinates = Coordinate(0, 0, 0) to maxCoordinate
    val offsetVoxels = coordinates.map(voxels).map(o => o.map(v => v.offset(offset)))
    offsetVoxels.foreach(v => renderIfExtant(v, world))
  }

  /**
    * Determines whether the structure's bounding box contains a coordinate.
    *
    * @param c the coordinate to inspect
    * @return whether that coordinate lies within the bounding box of this structure
    */
  def contains(c: Coordinate): Boolean = {
    offset <= c && c <= (maxCoordinate + offset)
  }

  private def renderIfExtant(v: Option[Voxel], world: World): Unit = {
    v.foreach(_.renderTo(world))
  }
}
