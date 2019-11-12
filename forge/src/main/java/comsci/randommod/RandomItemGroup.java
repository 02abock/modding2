package comsci.randommod;

import comsci.randommod.list.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RandomItemGroup extends ItemGroup{
	public RandomItemGroup(String label) 
	{
		super(label);
		
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.barnabic_ingot);
		//for block, use ItemStack(Item.BLOCK_TO_ITEM.get(Blocklist.cheese_block));
	}
}
