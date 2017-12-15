import net.morbz.minecraft.blocks.SimpleBlock

case class HollowCuboid(minCoordinate: Coordinate, maxCoordinate: Coordinate, block: SimpleBlock)
  extends Structure {

  override val voxels: List[Voxel] = FilledCuboid(minCoordinate, maxCoordinate, block).voxels.filter(
    voxel => List(minCoordinate.x, maxCoordinate.x).contains(voxel.coordinate.x) ||
      List(minCoordinate.y, maxCoordinate.y).contains(voxel.coordinate.y) ||
      List(minCoordinate.z, maxCoordinate.z).contains(voxel.coordinate.z)
  )
}
