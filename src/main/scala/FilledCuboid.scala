import net.morbz.minecraft.blocks.SimpleBlock

case class FilledCuboid(minCoordinate: Coordinate, maxCoordinate: Coordinate, block: SimpleBlock) extends Structure {
  override val voxels: List[Voxel] = {
    for (x <- minCoordinate.x to maxCoordinate.x;
         y <- minCoordinate.y to maxCoordinate.y;
         z <- minCoordinate.z to maxCoordinate.z)
      yield Voxel(Coordinate(x, y, z), block)
  }.toList
}