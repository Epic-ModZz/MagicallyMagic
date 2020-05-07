package com.Epic_ModZz.Magically_Magic.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelOcelot - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelSoul_Begger extends ModelBase {
    public ModelRenderer ocelotTail2;
    public ModelRenderer main;
    public ModelRenderer nose;
    public ModelRenderer ear1;
    public ModelRenderer ear2;
    public ModelRenderer ocelotBody;
    public ModelRenderer ocelotBackLeftLeg;
    public ModelRenderer ocelotBackRightLeg;
    public ModelRenderer ocelotTail;
    public ModelRenderer ocelotFrontRightLeg;
    public ModelRenderer ocelotFrontLeftLeg;

    public ModelSoul_Begger() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.ocelotBackRightLeg = new ModelRenderer(this, 27, 3);
        this.ocelotBackRightLeg.setRotationPoint(-1.100000023841858F, 18.0F, 5.0F);
        this.ocelotBackRightLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2, 0.0F);
        this.main = new ModelRenderer(this, 4, 0);
        this.main.setRotationPoint(0.0F, 15.0F, -9.0F);
        this.main.addBox(-2.5F, -2.0F, -3.0F, 5, 4, 5, 0.0F);
        this.ear2 = new ModelRenderer(this, 35, 0);
        this.ear2.setRotationPoint(0.0F, 15.0F, -9.0F);
        this.ear2.addBox(1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F);
        this.ocelotBackLeftLeg = new ModelRenderer(this, 55, 0);
        this.ocelotBackLeftLeg.setRotationPoint(1.100000023841858F, 18.0F, 5.0F);
        this.ocelotBackLeftLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2, 0.0F);
        this.ocelotTail2 = new ModelRenderer(this, 0, 0);
        this.ocelotTail2.setRotationPoint(0.0F, 18.2F, 12.1F);
        this.ocelotTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(ocelotTail2, 1.7278759594743864F, 0.0F, 0.0F);
        this.ear1 = new ModelRenderer(this, 29, 0);
        this.ear1.setRotationPoint(0.0F, 15.0F, -9.0F);
        this.ear1.addBox(-2.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F);
        this.nose = new ModelRenderer(this, 19, 0);
        this.nose.setRotationPoint(0.0F, 15.0F, -9.0F);
        this.nose.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 2, 0.0F);
        this.ocelotTail = new ModelRenderer(this, 49, 0);
        this.ocelotTail.setRotationPoint(0.0F, 15.0F, 8.0F);
        this.ocelotTail.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(ocelotTail, 0.9002408281786752F, 0.0F, 0.0F);
        this.ocelotFrontLeftLeg = new ModelRenderer(this, 0, 9);
        this.ocelotFrontLeftLeg.setRotationPoint(1.2000000476837158F, 13.800000190734863F, -5.0F);
        this.ocelotFrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.ocelotFrontRightLeg = new ModelRenderer(this, 55, 8);
        this.ocelotFrontRightLeg.setRotationPoint(-1.2000000476837158F, 13.800000190734863F, -5.0F);
        this.ocelotFrontRightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.ocelotBody = new ModelRenderer(this, 35, 0);
        this.ocelotBody.setRotationPoint(0.0F, 12.0F, -10.0F);
        this.ocelotBody.addBox(-2.0F, 3.0F, -8.0F, 4, 16, 6, 0.0F);
        this.setRotateAngle(ocelotBody, 1.5707963705062866F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ocelotBackRightLeg.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.main.offsetX, this.main.offsetY, this.main.offsetZ);
        GlStateManager.translate(this.main.rotationPointX * f5, this.main.rotationPointY * f5, this.main.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.2D, 1.0D);
        GlStateManager.translate(-this.main.offsetX, -this.main.offsetY, -this.main.offsetZ);
        GlStateManager.translate(-this.main.rotationPointX * f5, -this.main.rotationPointY * f5, -this.main.rotationPointZ * f5);
        this.main.render(f5);
        GlStateManager.popMatrix();
        this.ear2.render(f5);
        this.ocelotBackLeftLeg.render(f5);
        this.ocelotTail2.render(f5);
        this.ear1.render(f5);
        this.nose.render(f5);
        this.ocelotTail.render(f5);
        this.ocelotFrontLeftLeg.render(f5);
        this.ocelotFrontRightLeg.render(f5);
        this.ocelotBody.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;    
    }
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	this.ocelotFrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;
    	this.ocelotBackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;

    	this.ocelotFrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.ocelotBackRightLeg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F+ (float)Math.PI) * 1.4F * limbSwingAmount;    	
    	
    }
}
