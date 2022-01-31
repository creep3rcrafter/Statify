package creep3rcrafter.cth.client.screen.buttons;

import com.mojang.blaze3d.matrix.MatrixStack;

import creep3rcrafter.cth.client.screen.TreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.text.StringTextComponent;

public class TabButton extends AbstractButton{

	public TabButton(int xpos, int ypos, int width, int height) {
		super(xpos, ypos, width, height, StringTextComponent.EMPTY);
	}
	
	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		Minecraft minecraft = Minecraft.getInstance();
		minecraft.textureManager.bind(TreeScreen.RESOURCES);
		if (isHovered()) {
			blit(stack, x, y, 224, 200, 32, 28);
		}else {
			blit(stack, x, y, 224, 228, 32, 28);
		}
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		
	}

}
