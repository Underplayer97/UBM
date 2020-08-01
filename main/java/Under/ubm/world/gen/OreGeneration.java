package Under.ubm.world.gen;

import Under.ubm.config.OreGenConfig;
import Under.ubm.init.UbmBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	public static void setupOreGeneration()
	{
		if(OreGenConfig.generate_overworld.get())
		{
			for(Biome biome : ForgeRegistries.BIOMES)
			{				
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, UbmBlock.ancient_ore.getDefaultState(), OreGenConfig.ore_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
			}
		}
	}
}