import net.morbz.minecraft.blocks.DoorBlock.{DoorMaterial, HingeSide}
import net.morbz.minecraft.blocks.states.Facing4State
import net.morbz.minecraft.blocks.{DoorBlock, Material, SimpleBlock}
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld
  fill(world, Coordinate(-10, 0, -10), Coordinate(20, 0, 20), SimpleBlock.MOSSY_COBBLESTONE)

  private def makeWorld = {
    val layers = new DefaultLayers
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(0, 0, 0)
    new World(level, layers)
  }

  case class Coordinate(x: Int, y: Int, z: Int) {
    def +(c: Coordinate): Coordinate = {
      Coordinate(this.x + c.x, this.y + c.y, this.z + c.z)
    }

    def -(c: Coordinate): Coordinate = {
      Coordinate(this.x - c.x, this.y - c.y, this.z - c.z)
    }
  }

  def fill(world: World, c1: Coordinate, c2: Coordinate, block: SimpleBlock): Unit = {
    for (x <- c1.x to c2.x) {
      for (y <- c1.y to c2.y) {
        for (z <- c1.z to c2.z) {
          world.setBlock(x, y, z, block)
        }
      }
    }
  }

  def hollowFill(world: World, c1: Coordinate, c2: Coordinate, block: SimpleBlock): Unit = {
    fill(world, c1, c2, block)
    val x_sign = Math.signum(c2.x - c1.x).toInt
    val y_sign = Math.signum(c2.y - c1.y).toInt
    val z_sign = Math.signum(c2.z - c1.z).toInt
    val delta_coordinate = Coordinate(x_sign, y_sign, z_sign)
    val inner_c1 = c1 + delta_coordinate
    val inner_c2 = c2 - delta_coordinate
  }

  // Everything's set up so we're going to save the world.
  world.save()
}
