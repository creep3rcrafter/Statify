package creep3rcrafter.statify.client.screen.buttons;

import java.util.Arrays;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import creep3rcrafter.statify.client.screen.Tooltip;
import creep3rcrafter.statify.client.screen.TreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderTooltipEvent;

public class TabButton extends AbstractButton{
	
	public boolean state = false;
	public Tooltip tooltip;
	public String name;
	
	public int tooltipOffsetX = 0;
	public int tooltipOffsetY = 0;

	public TabButton(int xpos, int ypos, int width, int height, String name) {
		super(xpos-28, ypos, width, height, StringTextComponent.EMPTY);
		this.tooltip = new Tooltip();
		this.state = false;
		this.name = name;
	}
	public TabButton(int xpos, int ypos, int width, int height, String name, boolean state) {
		super(xpos-28, ypos, width, height, StringTextComponent.EMPTY);
		this.tooltip = new Tooltip();
		this.state = state;
		this.name = name;
	}
	
	public void setTooltipOffset(int x, int y) {
		this.tooltipOffsetX = x;
		this.tooltipOffsetY = y;
	}
	
	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		Minecraft minecraft = Minecraft.getInstance();
		minecraft.textureManager.bind(TreeScreen.RESOURCES);
		FontRenderer font = minecraft.font;
		if (this.active) {
			if (this.state) {
				blit(stack, x, y, 224, 228, 32, 28);
			}else {
				blit(stack, x, y, 224, 200, 32, 28);
			}
		}
		if (isMouseOver(mouseX, mouseY)) {
			List<ITextComponent> text = Arrays.asList(new StringTextComponent(name));
			tooltip.renderWrappedToolTip(stack, text, mouseX+tooltipOffsetX, mouseY+tooltipOffsetY, font);
		}
	}

	@Override
	public void onPress() {
		
	}
	
	
	public void setState() {
		this.state = !state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	public void setActive() {
		this.active = !this.active;
	}
	public void setActive(boolean state) {
		this.active = state;
	}

	public void setAsActiveTab(boolean state) {
		this.active = state;
		this.state = state;
	}

}
