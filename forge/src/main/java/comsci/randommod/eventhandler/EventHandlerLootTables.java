/*
package comsci.randommod.eventhandler;

import comsci.randommod.RandomMod;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTables;
@Mod.EventBusSubscriber
public class EventHandlerLootTables 
{
	@SubscribeEvent
	public static void lootLoaded(LootTableLoadEvent event) 
	{
		if(event.getName().equals(LootTables.)) 
		{
			LootTable customTable = event.getLootTableManager().getLootTableFromLocation(new ResourceLocation(RandomMod.modid, "src/main/resources/data/randommod/loot_tables/entities/chicken.json"));
			LootPool customPool = customTable.getPool("pickle");
			event.getTable().addPool(customPool);
		}
	}
	
	
	
	
}
*/