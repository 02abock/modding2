package comsci.randommod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
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
	
}
