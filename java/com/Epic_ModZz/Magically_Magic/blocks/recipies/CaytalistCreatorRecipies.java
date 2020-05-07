package com.Epic_ModZz.Magically_Magic.blocks.recipies;
import java.util.Map;
import java.util.Map.Entry;

import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
public class CaytalistCreatorRecipies {
	
	
	
	private static final CaytalistCreatorRecipies INSTANCE = new CaytalistCreatorRecipies();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static CaytalistCreatorRecipies getInstance() {
		return INSTANCE;
	}

	private CaytalistCreatorRecipies() 
	{
		addCaytalistRecipe(new ItemStack(ModItems.CAYTALIST), new ItemStack(ModItems.SHADE), new ItemStack(ModItems.CAYTALIST_SHADOW), 5.0F);
		addCaytalistRecipe(new ItemStack(ModItems.CAYTALIST), new ItemStack(ModItems.JELLIED_BLOOD), new ItemStack(ModItems.CAYTALIST_BLOOD), 5.0F);
		addCaytalistRecipe(new ItemStack(Blocks.SPONGE), new ItemStack(ModItems.MAGIC_ESSENSE), new ItemStack(ModItems.PURIFIED_MAGIC_ESSENSE), 5.0F);


	}

	
	public void addCaytalistRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getCaytalistResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getCaytalistResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getCaytalistExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}


}

