package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	public static enum EnumType implements IStringSerializable{
		
		PARADOXITE_ORE(0,"Paradoxite_Ore");

		
			private static final EnumType[] META_LOOKUP = new EnumType[values().length];
			private final int meta;
			private final String name, Unlocalizedname;

		private EnumType(int meta, String name,String unlocalizedname) {
			this.meta = meta;
			this.name = name;
			this.Unlocalizedname = unlocalizedname;
		}
		private EnumType(int meta, String name) {
			this(meta,name,name);
		}
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
		public int getMeta() {
			// TODO Auto-generated method stub
			return this.meta;
		}
		public String getUnlocalizedName() {
			// TODO Auto-generated method stub
			return this.Unlocalizedname;
		}		
		@Override
		public String toString() {

			return this.name;
		}
		public static EnumType byMetaData(int meta) {
			return META_LOOKUP[meta];
		}
		static
		{
			for(EnumType enumtype : values()) {
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
}	


