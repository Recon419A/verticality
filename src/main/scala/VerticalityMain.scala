import net.morbz.minecraft.blocks.DoorBlock.{DoorMaterial, HingeSide}
import net.morbz.minecraft.blocks.{DoorBlock, Material, SimpleBlock}
import net.morbz.minecraft.blocks.states.Facing4State
import net.morbz.minecraft.level.{FlatGenerator, GameType, Level}
import net.morbz.minecraft.world.{DefaultLayers, World}
import java.nio.file.Files.copy

object VerticalityMain extends App {


  // Create the base layers of the generated world.// Create the base layers of the generated world.

  // We set the bottom layer of the world to be bedrock and the 20 layers above to be melon
  // blocks.
  val layers = new DefaultLayers
  layers.setLayer(0, Material.BEDROCK)
  layers.setLayers(1, 20, Material.MELON_BLOCK)

  // Create the internal Minecraft world generator.
  // We use a flat generator. We do this to make sure that the whole world will be paved
  // with melons and not just the part we generated.
  val generator = new FlatGenerator(layers)

  // Create the level configuration.
  // We set the mode to creative creative mode and name our world. We also set the spawn point
  // in the middle of our glass structure.
  val level = new Level("Verticality", generator)
  level.setGameType(GameType.CREATIVE)
  level.setSpawnPoint(50, 0, 50)

  // Now we create the world. This is where we can set our own blocks.
  val world = new World(level, layers)

  // Create a huge structure of glass that has an area of 100x100 blocks and is 50 blocks
  // height. On top of the glass structure we put a layer of grass.
  var x = 0
  while ( {
    x < 100
  }) {
    var z = 0
    while ( {
      z < 100
    }) { // Set glass
      var y = 0
      while ( {
        y < 50
      }) {
        world.setBlock(x, y, z, SimpleBlock.GLASS)

        {
          y += 1;
          y - 1
        }
      }
      // Set grass
      world.setBlock(x, 50, z, SimpleBlock.GRASS)

      {
        z += 1;
        z - 1
      }
    }

    {
      x += 1;
      x - 1
    }
  }

  // Now we create the door. It consists of 2 blocks, that's why we can't use a SimpleBlock
  // here.
  world.setBlock(50, 51, 50, DoorBlock.makeLower(DoorMaterial.OAK, Facing4State.EAST, false))
  world.setBlock(50, 52, 50, DoorBlock.makeUpper(DoorMaterial.OAK, HingeSide.LEFT))

  // Everything's set up so we're going to save the world.
  world.save()
}
