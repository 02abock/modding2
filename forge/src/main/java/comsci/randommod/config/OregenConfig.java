package comsci.randommod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	
	public static ForgeConfigSpec.IntValue barnabic_ore_chance;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		
		server.comment("Oregen Config");
		
		barnabic_ore_chance = server.comment("chace for barnbic ore to spawn")
				.defineInRange("orgen.barnabic_ore_chance", 100, 1, 100000);
		
	}

}
