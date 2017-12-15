import net.morbz.minecraft.blocks.DoorBlock.{DoorMaterial, HingeSide}
import net.morbz.minecraft.blocks.states.Facing4State
import net.morbz.minecraft.blocks.{DoorBlock, Material, SimpleBlock}
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld
  HollowCuboid(Coordinate(-20, 0, -20), Coordinate(20, 6, 20), SimpleBlock.MOSSY_COBBLESTONE).renderTo(world)

  private def makeWorld = {
    val layers = new DefaultLayers
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(0, 0, 0)
    new World(level, layers)
  }

  case class FilledCuboid(minCoordinate: Coordinate, maxCoordinate: Coordinate, block: SimpleBlock) {
    def renderTo(world: World): Unit = {
      for (x <- minCoordinate.x to maxCoordinate.x) {
        for (y <- minCoordinate.y to maxCoordinate.y) {
          for (z <- minCoordinate.z to maxCoordinate.z) {
            world.setBlock(x, y, z, block)
          }
        }
      }
    }
  }

  case class HollowCuboid(minCoordinate: Coordinate, maxCoordinate: Coordinate, block: SimpleBlock) {
    def renderTo(world: World): Unit = {
      FilledCuboid(minCoordinate, maxCoordinate, block).renderTo(world)
      FilledCuboid(minCoordinate + Coordinate(1, 1, 1), maxCoordinate - Coordinate(1, 1, 1), SimpleBlock.AIR).renderTo(world)
    }
  }

  // Everything's set up so we're going to save the world.
  world.save()
}
