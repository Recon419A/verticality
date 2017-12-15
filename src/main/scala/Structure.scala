import net.morbz.minecraft.world.World

trait Structure {
  val voxels: List[Voxel]
  val offset: Coordinate

  def renderTo(world: World): Unit = {
    val translatedVoxels = voxels.map(v => Voxel(v.coordinate + offset, v.block))
    translatedVoxels.foreach(voxel => voxel.renderTo(world))
  }
}
