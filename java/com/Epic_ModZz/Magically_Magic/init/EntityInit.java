package com.Epic_ModZz.Magically_Magic.init;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.entity.EntitySoul_Begger;
import com.Epic_ModZz.Magically_Magic.entity.SkyBolt;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("Shade", EntityShade.class,Reference.ENTITY_SHADE,30,000000,5003066);
		registerEntity("Soul_Begger", EntitySoul_Begger.class,Reference.ENTITY_SOUL_BEGGER,10,16777215,14869236);
		registerProjectile("SkyBolt",Reference.SKYBOLT,SkyBolt.class, ModItems.ITEM_SKY_SWORD);
	}
	

	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":"+ name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	
	private static void registerProjectile(String name, int id, Class<?extends Entity> entity, Item item) {
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, Main.instance, 64, 10, true);
	}
}
