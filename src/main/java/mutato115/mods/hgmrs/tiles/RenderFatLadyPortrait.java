package mutato115.mods.hgmrs.tiles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderFatLadyPortrait extends TileEntitySpecialRenderer {
	
	
	private ModelFatLadyPortrait model;
	private ResourceLocation tileTexture = new ResourceLocation("hgmrsmod:textures/blocks/fat_lady_portrait.png");
	
	public RenderFatLadyPortrait() {
		
		model = new ModelFatLadyPortrait();
		
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        int metadata = tile.getBlockMetadata();
        int rotationAngle = 0;
        if (metadata % 4 == 0) {
            rotationAngle = 180;
        }

        if (metadata % 4 == 1) {
            rotationAngle = -180;
        }

        if (metadata % 4 == 2) {
            rotationAngle = 1000000000;
        }

        if (metadata % 4 == 3) {
            rotationAngle = 0;
        }

        GL11.glRotatef(180.0F, 180.0F, 0.0F, (float)rotationAngle);
        this.bindTexture(tileTexture);
        GL11.glPushMatrix();
        this.model.render((Entity)null, 0, 0.1f, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
		
	}
	
	
}
