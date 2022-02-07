package creep3rcrafter.statify.client.screen.buttons;

import com.mojang.blaze3d.matrix.MatrixStack;

import creep3rcrafter.statify.client.screen.Tooltip;
import creep3rcrafter.statify.client.screen.TreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class TreeButton extends AbstractButton {

	public ItemStack item;
	public Tooltip tooltip;
	public int uiWidth = 0;
	public int uiHeight = 0;

	public TreeButton(int xpos, int ypos, int width, int height, ItemStack itemstack, int uiWidth, int uiHeight) {
		super(xpos, ypos, width, height, StringTextComponent.EMPTY);
		this.item = itemstack;
		this.tooltip = new Tooltip();
		this.uiHeight = uiHeight;
		this.uiWidth = uiWidth;
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		int top = (uiHeight - 194) / 2;
		int left = (uiWidth - 176) / 2;
		Minecraft minecraft = Minecraft.getInstance();
		minecraft.textureManager.bind(TreeScreen.RESOURCES);
		FontRenderer font = minecraft.font;
;		
		
		blit(stack, x, y, 0, 224, 158, 32);
		ItemRenderer ir = minecraft.getItemRenderer();
		stack.pushPose();
		if (!item.isEmpty()) {
			ir.renderGuiItem(item, x + 8, y + 8);
		}
		stack.popPose();
		if (isMouseOver(mouseX, mouseY)) {
			tooltip.renderItemTooltip(stack, item, left + 170, top + 30);
		}
		ITextComponent text = item.getItem().getName(item);
		font.draw(stack, text, x + 28, y + 6, 0xffffff);
	}

	@Override
	public void onPress() {

	}
	
	public void setItem(ItemStack itemStack) {
		this.item = itemStack;
	}

}
