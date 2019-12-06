package comsci.randommod.list;

import net.minecraft.item.Food;

public class FoodList 
{
	public static Food donutFood = (new Food.Builder()).hunger(3).saturation(0.2f).build();
	public static Food glazedDonutFood = (new Food.Builder()).hunger(3).saturation(0.3f).build();
	public static Food powderedDonutFood = (new Food.Builder()).hunger(3).saturation(0.3f).build();
	public static Food elongatedDonutFood = (new Food.Builder()).hunger(3).saturation(0.2f).build();
	public static Food pretzelFood = (new Food.Builder()).hunger(3).saturation(0.2f).build();
	public static Food doughFood = (new Food.Builder()).hunger(1).saturation(0.1f).build();
	public static Food unfriedElongatedDonutFood = (new Food.Builder()).hunger(1).saturation(0.1f).build();
	public static Food unfriedDonutFood = (new Food.Builder()).hunger(1).saturation(0.1f).build();
	public static Food unfriedPretzelFood = (new Food.Builder()).hunger(1).saturation(0.1f).build();
}
