package com.Epic_ModZz.Magically_Magic.init;

import com.Epic_ModZz.Magically_Magic.fluids.FluidLiquid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
	public static final Fluid MAGIC_WATER = new FluidLiquid("magical_solution", new ResourceLocation("magi:blocks/magical_solution_still"), new ResourceLocation("magi:blocks/magical_solution_flow"));
	
	
	
	public static void registerFluids() {
		registerFluid(MAGIC_WATER);
	}
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
