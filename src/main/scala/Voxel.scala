import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World

case class Voxel(coordinate: Coordinate, block: SimpleBlock) {
  def renderTo(world: World): Unit = {
    world.setBlock(coordinate.x, coordinate.y, coordinate.z, block)
  }
}
