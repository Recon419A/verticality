import net.morbz.minecraft.blocks.DoorBlock.{DoorMaterial, HingeSide}
import net.morbz.minecraft.blocks.states.Facing4State
import net.morbz.minecraft.blocks.{DoorBlock, Material, SimpleBlock}
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld
  HollowCuboid(Coordinate(-4, 0, -4), Coordinate(4, 4, 4), Coordinate(0, 0, 0), SimpleBlock.MOSSY_COBBLESTONE).renderTo(world)

  private def makeWorld = {
    val layers = new DefaultLayers
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(0, 0, 0)
    new World(level, layers)
  }

  // Everything's set up so we're going to save the world.
  world.save()
}
