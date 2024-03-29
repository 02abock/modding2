package comsci.randommod.world;



import comsci.randommod.config.OregenConfig;
import comsci.randommod.list.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;


public class OreGeneration {
	public static void setupOreGeneration() 
	{
		
			for(Biome biome : ForgeRegistries.BIOMES)
		
			{
						
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.barnabic_ore.getDefaultState(), 6), Placement.COUNT_RANGE, new CountRangeConfig(1000,4,0,100) ));
		}
		
		
		
	}

}
