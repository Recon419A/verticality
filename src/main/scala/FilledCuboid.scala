import net.morbz.minecraft.blocks.SimpleBlock

class FilledCuboid(minCoordinate: Coordinate, maxCoordinate: Coordinate, override val offset: Coordinate, block: SimpleBlock) extends Structure {
  override val voxels: List[Voxel] = {
    for (x <- minCoordinate.x to maxCoordinate.x;
         y <- minCoordinate.y to maxCoordinate.y;
         z <- minCoordinate.z to maxCoordinate.z)
      yield Voxel(Coordinate(x, y, z), block)
  }.toList
}