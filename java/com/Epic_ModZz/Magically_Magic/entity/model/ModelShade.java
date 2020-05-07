package com.Epic_ModZz.Magically_Magic.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelSkeletonHead - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelShade extends ModelBase {
    public ModelRenderer skeletonHead;

    public ModelShade() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.skeletonHead = new ModelRenderer(this, 0, 35);
        this.skeletonHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skeletonHead.addBox(-4.0F, 11.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.skeletonHead.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
