package mutato115.mods.hgmrs.tiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFatLadyPortrait extends ModelBase
{
  //fields
    ModelRenderer Portrait;
    ModelRenderer UpperFrame;
    ModelRenderer LowerFrame;
    ModelRenderer LeftFrame;
    ModelRenderer RightFrame;
  
  public ModelFatLadyPortrait()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Portrait = new ModelRenderer(this, 0, 0);
      Portrait.addBox(0F, -64F, -1F, 64, 64, 1);
      Portrait.setRotationPoint(-8F, 24F, 8F);
      Portrait.setTextureSize(64, 32);
      Portrait.mirror = true;
      setRotation(Portrait, 0F, 0F, 0F);
      UpperFrame = new ModelRenderer(this, 0, 0);
      UpperFrame.addBox(0F, -0.5F, -2F, 64, 1, 1);
      UpperFrame.setRotationPoint(-8F, -39.5F, 8F);
      UpperFrame.setTextureSize(64, 32);
      UpperFrame.mirror = true;
      setRotation(UpperFrame, 0F, 0F, 0F);
      LowerFrame = new ModelRenderer(this, 0, 0);
      LowerFrame.addBox(0F, 0F, -2F, 64, 1, 1);
      LowerFrame.setRotationPoint(-8F, 23F, 8F);
      LowerFrame.setTextureSize(64, 32);
      LowerFrame.mirror = true;
      setRotation(LowerFrame, 0F, 0F, 0F);
      LeftFrame = new ModelRenderer(this, 0, 0);
      LeftFrame.addBox(0F, 0F, -2F, 1, 62, 1);
      LeftFrame.setRotationPoint(-8F, -39F, 8F);
      LeftFrame.setTextureSize(64, 32);
      LeftFrame.mirror = true;
      setRotation(LeftFrame, 0F, 0F, 0F);
      RightFrame = new ModelRenderer(this, 0, 0);
      RightFrame.addBox(63F, 0F, -2F, 1, 62, 1);
      RightFrame.setRotationPoint(-8F, -39F, 8F);
      RightFrame.setTextureSize(64, 32);
      RightFrame.mirror = true;
      setRotation(RightFrame, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Portrait.render(f5);
    UpperFrame.render(f5);
    LowerFrame.render(f5);
    LeftFrame.render(f5);
    RightFrame.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
