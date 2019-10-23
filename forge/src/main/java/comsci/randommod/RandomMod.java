package comsci.randommod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import comsci.randommod.list.BlockList;
import comsci.randommod.list.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
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
			event.getRegistry().registerAll(
					ItemList.barnabic_ingot=new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("barnabic_ingot"))
			);
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(
				BlockList.barnabic_ore=new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, resistanceIn))
			);
			logger.info("Items registered.");
		}
		
		
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid,name);
		}
	}
	
}
