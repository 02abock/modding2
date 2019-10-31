package comsci.randommod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import comsci.randommod.list.BlockList;
import comsci.randommod.list.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("randommod")

public class RandomMod 
{
	public static RandomMod instance;
	public static final String modid = "randommod";
	private static final Logger logger = LogManager.getLogger(modid);//figure out
	
	public RandomMod() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		logger.info("setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		logger.info("clientRegisties method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.pickle_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("pickle_item")),
				ItemList.cheese_block = new BlockItem(BlockList.cheese_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.cheese_block.getRegistryName())
			);
			
			logger.info("Items registered.");
		}
		
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.cheese_block = new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("cheese_block"))
			);
			
			logger.info("Blocks registered.");
		}
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid,name);
		}
	}
}
