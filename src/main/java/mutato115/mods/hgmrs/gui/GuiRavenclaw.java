package mutato115.mods.hgmrs.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import mutato115.mods.hgmrs.HGMRsMod;
import mutato115.mods.hgmrs.json.EntranceResponsePacket;
import mutato115.mods.hgmrs.json.Question;
import mutato115.mods.hgmrs.json.UniquePlayer;
import mutato115.mods.hgmrs.json.UniquePosition;
import mutato115.mods.hgmrs.lib.HGMRStatic;
import mutato115.mods.hgmrs.network.EntrancePacketToServer;
import mutato115.mods.hgmrs.utils.HGMRUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import scala.reflect.internal.Trees.This;

public class GuiRavenclaw extends GuiScreen {
	
	private int guiWidth = 176;
	private int guiHeight = 166;
	
	private int guiX = 0;
	private int guiY = 0;
	
	private String question;
	private String answer;
	
	private int doorX, doorY, doorZ;
	
	private GuiTextField questionField;
	private GuiButton confirmButton;
	
	public GuiRavenclaw(Question question, int x, int y, int z) {
		this.question = question.getQuestion();
		this.answer = question.getAnswer();
		this.doorX = x;
		this.doorY = y;
		this.doorZ = z;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		
		guiX = (width - guiWidth) / 2;
		guiY = (height - guiHeight) / 2;
		
		this.questionField = new GuiTextField(this.fontRendererObj, guiX + 16, guiY + 127, 140, 12);
        this.questionField.setMaxStringLength(77);
        this.questionField.setEnableBackgroundDrawing(false);
        this.questionField.setText("");
        
        this.confirmButton = new GuiButton(0, guiX + 91, guiY + 141, 73, 20, I18n.format("gui.hgmrsmod.ravenclaw.confirm"));
        this.buttonList.add(this.confirmButton);
	}
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		Keyboard.enableRepeatEvents(true);
		
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation("hgmrsmod:textures/gui/ravenclaw.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		
		if (this.questionField.isFocused()) {
        	drawTexturedModalRect(guiX + 12, guiY + 123, 0, 166, 152, 16);
        } else {
        	drawTexturedModalRect(guiX + 12, guiY + 123, 0, 182, 152, 16);
        }
		
		fontRendererObj.drawString("Ravenclaw", guiX + 15, guiY + 12, 0x0E8BF8);
		fontRendererObj.drawSplitString(this.question, guiX + 16, guiY + 36, 144, 0x000000);
		
		this.questionField.drawTextBox();
		
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
	}
	
	@Override
	public void keyTyped(char p_keyTyped_1_, int p_keyTyped_2_) {
        if (!this.questionField.textboxKeyTyped(p_keyTyped_1_, p_keyTyped_2_)) {
        	super.keyTyped(p_keyTyped_1_, p_keyTyped_2_);
        }

    }
	
	@Override
	protected void mouseClicked(int p_mouseClicked_1_, int p_mouseClicked_2_, int p_mouseClicked_3_) {
        super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_);
        this.questionField.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_);
        
        GL11.glColor4f(1, 1, 1, 1);
        mc.renderEngine.bindTexture(new ResourceLocation("hgmrsmod:textures/gui/ravenclaw.png"));
        if (this.questionField.isFocused()) {
        	drawTexturedModalRect(guiX + 12, guiY + 132, 0, 166, 152, 16);
        } else {
        	drawTexturedModalRect(guiX + 12, guiY + 132, 0, 182, 152, 16);
        }
    }
	
	@Override
    protected void actionPerformed(GuiButton button){
        if(button.id == 0) {
    		
    		if (HGMRUtils.isSameSimplifiedString(this.answer, this.questionField.getText())) {
    			EntranceResponsePacket packet = new EntranceResponsePacket(new UniquePosition(this.doorX, this.doorY, this.doorZ));
    			
    			HGMRsMod.proxy.getNetworkWrapper().sendToServer(new EntrancePacketToServer(HGMRStatic.House.RAVENCLAW, true, packet));
    			HGMRsMod.proxy.getClientPlayer().addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + I18n.format("chat.hgmrsmod.ravenclaw.right_answer")));
    		} else {
    			HGMRsMod.proxy.getClientPlayer().addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + I18n.format("chat.hgmrsmod.ravenclaw.wrong_answer")));
    		}
    		this.mc.displayGuiScreen(null);
        }
    }
	
}
