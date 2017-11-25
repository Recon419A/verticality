import net.morbz.minecraft.blocks.DoorBlock.{DoorMaterial, HingeSide}
import net.morbz.minecraft.blocks.states.Facing4State
import net.morbz.minecraft.blocks.{DoorBlock, Material, SimpleBlock}
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}

object VerticalityMain extends App {
  val world = makeWorld
  world.setBlock(50, 30, 50, SimpleBlock.MOSSY_COBBLESTONE)

  private def makeWorld = {
    val layers = new DefaultLayers
    layers.setLayer(0, Material.BEDROCK)
    layers.setLayers(1, 20, Material.GRASS)
    val generator = new FlatGenerator(layers)
    val level = new Level("Verticality", generator)
    level.setGameType(GameType.CREATIVE)
    level.setSpawnPoint(50, 30, 50)
    new World(level, layers)
  }


  // Everything's set up so we're going to save the world.
  world.save()
}
