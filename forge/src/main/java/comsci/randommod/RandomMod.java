package comsci.randommod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import comsci.randommod.config.Config;
import comsci.randommod.list.BlockList;
import comsci.randommod.list.FoodList;
import comsci.randommod.list.ItemList;
import comsci.randommod.list.ToolMaterialList;
import comsci.randommod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("randommod")

public class RandomMod 
{
	public static RandomMod instance;
	public static final String modid = "randommod";
	private static final Logger logger = LogManager.getLogger(modid);
	public static final ItemGroup random = new RandomItemGroup("random");
	
	public RandomMod() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);

		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("randommod-client.toml").toString());
		Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("randommod-server.toml").toString());

		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		OreGeneration.setupOreGeneration();
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
					ItemList.barnabic_ingot = new Item(new Item.Properties().group(random)).setRegistryName(location("barnabic_ingot")),
					ItemList.flour = new Item(new Item.Properties().group(random)).setRegistryName(location("flour")),
					ItemList.powdered_sugar = new Item(new Item.Properties().group(random)).setRegistryName(location("powdered_sugar")),					
					ItemList.glaze = new Item(new Item.Properties().group(random)).setRegistryName(location("glaze")),
					
					ItemList.unfried_elongated_donut = new Item(new Item.Properties().food(FoodList.unfriedElongatedDonutFood).group(random)).setRegistryName(location("unfried_elongated_donut")),
					ItemList.elongated_donut = new Item(new Item.Properties().food(FoodList.elongatedDonutFood).group(random)).setRegistryName(location("elongated_donut")),
					ItemList.unfried_donut = new Item(new Item.Properties().food(FoodList.unfriedDonutFood).group(random)).setRegistryName(location("unfried_donut")),
					ItemList.donut = new Item(new Item.Properties().food(FoodList.donutFood).group(random)).setRegistryName(location("donut")),
					ItemList.glazed_donut = new Item(new Item.Properties().food(FoodList.glazedDonutFood).group(random)).setRegistryName(location("glazed_donut")),
					ItemList.powdered_donut = new Item(new Item.Properties().food(FoodList.powderedDonutFood).group(random)).setRegistryName(location("powdered_donut")),
					ItemList.pretzel = new Item(new Item.Properties().food(FoodList.pretzelFood).group(random)).setRegistryName(location("pretzel")),
					ItemList.unfried_pretzel = new Item(new Item.Properties().food(FoodList.unfriedPretzelFood).group(random)).setRegistryName(location("unfried_pretzel")),
					ItemList.dough = new Item(new Item.Properties().food(FoodList.doughFood).group(random)).setRegistryName(location("dough")),
					
					ItemList.barnabic_ore = new BlockItem(BlockList.barnabic_ore, new Item.Properties().group(random)).setRegistryName(BlockList.barnabic_ore.getRegistryName()),
					ItemList.cheese_block = new BlockItem(BlockList.cheese_block, new Item.Properties().group(random)).setRegistryName(BlockList.cheese_block.getRegistryName()),
					
					ItemList.pickle_item = new SwordItem(ToolMaterialList.pickle, 0, 1.0f, new Item.Properties().group(random)).setRegistryName(location("pickle_item"))

					);
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(
				BlockList.barnabic_ore=new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName(location("barnabic_ore")),
				BlockList.cheese_block = new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("cheese_block"))
			);
			logger.info("Blcoks registered.");
		}
		
		
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid,name);
		}
	}
	
}
