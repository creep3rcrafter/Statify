package creep3rcrafter.cth.client.screen.slider;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sun.jna.platform.win32.WinDef.HICON;

import creep3rcrafter.cth.client.screen.TreeScreen;
import creep3rcrafter.math.BetterMath;
import net.java.games.input.Mouse;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.AbstractSlider;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;

public class TreeSlider extends AbstractButton {

	public double value = 0;

	private int yOffset;

	public int mouseY;
	public int mouseX;
	
	public double scrollOffset = 0;

	public TreeSlider(int xpos, int ypos, int height, double value) {
		super(xpos, ypos, 4, height, StringTextComponent.EMPTY);
		value = 0;
	}

	private void setValue(double value) {
		double d0 = this.value;
		this.value = MathHelper.clamp(value, 0.0D, 1.0D);
		if (d0 != this.value) {
			// this.applyValue();
		}

		// this.updateMessage();
	}

	public void setValueFromMouse(double value) {
		this.setValue((value - (double) (this.y + 4)) / (double) (this.height - 8));
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		Minecraft minecraft = Minecraft.getInstance();
		minecraft.textureManager.bind(TreeScreen.RESOURCES);
		FontRenderer font = minecraft.font;
		this.renderButton(stack, mouseX, mouseY, partialTicks);
		this.blit(stack, x - 1, y, 176, 26, 4, 1);
		this.blit(stack, x, y + height - 1, 176, 30, 4, 1);
		for (int i = 0; i < height - 2; i++) {
			if (i % 2 == 0) {
				// even
				this.blit(stack, x, y + i + 1, 176, 28, 4, 1);
			} else {
				// odd
				this.blit(stack, x, y + i + 1, 176, 29, 4, 1);
			}
		}
		if (mouseScrolled(mouseX, mouseY, partialTicks)) {
			scrollOffset++;
		}
		ITextComponent text = new StringTextComponent("(" + mouseX + "), (" + mouseY + "), (" + value + ")");
		ITextComponent text2 = new StringTextComponent("(" + (int) BetterMath.map(value, 0.0, 1.0, 0, 65) + "), (" + scrollOffset + ")");
		this.blit(stack, x - 1, yOffset, 176, 21, 6, 6);
		font.draw(stack, text, x + 20, y + 6, 0xffffff);
		font.draw(stack, text2, x + 20, y + 30, 0xffffff);
		this.mouseX = mouseX;
		this.mouseY = mouseY;
	}

	@Override
	public void onPress() {
		int mouse = BetterMath.clamp(mouseY, y + 4, y + height - 4);
		yOffset = BetterMath.map(mouse, y + 4, y + height - 4, y-2, y + height - 6);
		value = BetterMath.map(mouse, y + 4, y + height - 4, 0.0, 1.0);

	}

}
