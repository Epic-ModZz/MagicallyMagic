package com.Epic_ModZz.Magically_Magic.entity.render;

import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.entity.EntitySoul_Begger;
import com.Epic_ModZz.Magically_Magic.entity.model.ModelShade;
import com.Epic_ModZz.Magically_Magic.entity.model.ModelSoul_Begger;
import com.Epic_ModZz.Magically_Magic.util.Reference;import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSoul_Begger extends RenderLiving<EntitySoul_Begger> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ModelSoul_Begger.png");
	
	public RenderSoul_Begger(RenderManager manager) {
		super(manager, new ModelSoul_Begger(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySoul_Begger entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

	@Override
	protected void applyRotations(EntitySoul_Begger entityLiving, float p_77843_2, float rotationYaw, float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77843_2, rotationYaw, partialTicks);
	}


}
