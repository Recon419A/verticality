import net.morbz.minecraft.blocks.SimpleBlock
import net.morbz.minecraft.world.World

class Voxel {

  case class Voxel(coordinate: Coordinate, block: SimpleBlock) {
    def render(world: World): Unit = {
      world.setBlock(coordinate.x, coordinate.y, coordinate.z, block)
    }
  }

}
