package com.Epic_ModZz.Magically_Magic.entity.render;

import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.entity.model.ModelShade;
import com.Epic_ModZz.Magically_Magic.util.Reference;import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShade extends RenderLiving<EntityShade> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/shade.png");
	
	public RenderShade(RenderManager manager) {
		super(manager, new ModelShade(), 0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShade entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityShade entityLiving, float p_77843_2, float rotationYaw, float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77843_2, rotationYaw, partialTicks);
	}
}
