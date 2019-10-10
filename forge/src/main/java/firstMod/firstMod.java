package firstMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("adambock")
public class firstMod{
	
	public static firstMod instance;
	public static final String modid="adamBock";
	private static final Logger logger = LogManager.getLogger(modid);
		
		public firstMod() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	 private void setup(final FMLCommonSetupEvent event) {
		 logger.info("setup method registered");
	 }
	 
private void clientRegisteries(final FMLClientSetupEvent event) {
		 
	 }
	 
	 
}