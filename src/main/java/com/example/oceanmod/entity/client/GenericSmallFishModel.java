package com.example.oceanmod.entity.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.geom.PartPose;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class GenericSmallFishModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new ResourceLocation("oceanmod", "generic_small_fish"), "main");

    private final ModelPart body;
    private final ModelPart bone4;
    private final ModelPart bone3;
    private final ModelPart bone;
    private final ModelPart bone2;

    public GenericSmallFishModel(ModelPart root) {
        this.body = root.getChild("body");
        this.bone4 = root.getChild("bone4");
        this.bone3 = root.getChild("bone3");
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 8).addBox(0.0F, -2.5F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 21.5F, 1.0F));

        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create()
                .texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 22.0F, -1.0F));

        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create()
                .texOffs(0, 8).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 21.5F, 3.0F));

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), 
            PartPose.offset(1.0F, 22.5F, 0.0F));

        bone.addOrReplaceChild("cube_r1", CubeListBuilder.create()
                .texOffs(12, 3).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9163F, 0.4363F, -0.3491F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), 
            PartPose.offset(-1.0F, 22.5F, 0.0F));

        bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create()
                .texOffs(12, 3).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9163F, -0.4363F, 0.3491F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Animation will be handled separately
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}