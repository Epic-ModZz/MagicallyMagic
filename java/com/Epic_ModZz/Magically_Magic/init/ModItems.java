package com.Epic_ModZz.Magically_Magic.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Epic_ModZz.Magically_Magic.items.ItemBase;
import com.Epic_ModZz.Magically_Magic.items.properties.Magic_Essense;
import com.Epic_ModZz.Magically_Magic.items.properties.PhaseOrb;
import com.Epic_ModZz.Magically_Magic.items.properties.SpruceStaff;
import com.Epic_ModZz.Magically_Magic.items.properties.SwordOfSky;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item SHADE = new ItemBase("shade");
	public static final Item JELLIED_BLOOD = new ItemBase("jellied_blood");
	public static final Item MAGIC_ESSENSE = new ItemBase("magic_essense");
	public static final Item AWAKENED_SPELLBOOK = new ItemBase("awakened_spellbook");
	public static final Item ENCRYPTED_SPELLBOOK = new Magic_Essense("encrypted_spellbook");
	public static final Item ORB_OF_CHANNELING = new ItemBase("orb_of_channeling");
	public static final Item CAYTALIST = new ItemBase("caytalist");
	public static final Item CAYTALIST_AIR = new ItemBase("caytalist_air");
	public static final Item CAYTALIST_BLOOD = new ItemBase("caytalist_blood");
	public static final Item CAYTALIST_WATER = new ItemBase("caytalist_water");
	public static final Item CAYTALIST_EARTH = new ItemBase("caytalist_earth");
	public static final Item CAYTALIST_SHADOW = new ItemBase("caytalist_shadow");
	public static final Item FORGED_IRON = new ItemBase("forged_iron");
	public static final Item CORE_SORC = new ItemBase("core_of_deep_sorcery");
	public static final Item MEC_CORE = new ItemBase("mechanism_of_deep_sorcery");

	public static final Item SPRUCE_STAFF = new SpruceStaff("spruce_staff");
	public static final Item PURIFIED_MAGIC_ESSENSE = new ItemBase("purified_magic_essense");

	public static final Item PHASE_ORG = new PhaseOrb("phase_orb");

	
	
	//tools 
	public static final Item ITEM_SKY_SWORD = new SwordOfSky("skyward_dagger", Item.ToolMaterial.IRON);

	
	
	//misc
	//public static final Item ITEM_FORSAKEN_EYE = new ItemBase("forsaken_eye");

}
