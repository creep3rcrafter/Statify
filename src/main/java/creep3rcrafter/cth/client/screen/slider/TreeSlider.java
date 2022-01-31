package creep3rcrafter.cth.client.screen.slider;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sun.jna.platform.win32.WinDef.HICON;

import creep3rcrafter.cth.client.screen.TreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.AbstractSlider;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;

public class TreeSlider extends AbstractButton {

	protected double value;

	public TreeSlider(int xpos, int ypos, int height, double value) {
		super(xpos, ypos, 4, height, StringTextComponent.EMPTY);
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
		this.blit(stack, x-1, y, 176, 26, 4, 1);
		this.blit(stack, x, y + height-1, 176, 30, 4, 1);
		for (int i = 0; i < height - 2; i++) {
			if (i % 2 == 0) {
				// even
				this.blit(stack, x, y + i + 1, 176, 28, 4, 1);
			} else {
				// odd
				this.blit(stack, x, y + i + 1, 176, 29, 4, 1);
			}
		}
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub

	}

}
