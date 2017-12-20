package com.recon419a.verticality.structures

import com.recon419a.verticality.util.{Coordinate, Voxel}

trait MultiStructure extends Structure {
  val components: List[Structure]

  /**
    * A function defining the procedural shape of this multi-structure. The first of this structure's components which
    * wishes to set a voxel is allowed to set that voxel; if none of the components sets that voxel, it will be None.
    * This is the only voxel-defining function which needs to be overridden; the rest of the accessors depend upon it.
    *
    * @return a function mapping from coordinates to voxels
    */
  override def voxel: Coordinate => Option[Voxel] = {
    coordinate => components.flatMap(_.translatedVoxel(coordinate)).headOption
  }
}
