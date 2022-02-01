package creep3rcrafter.cth.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;

import creep3rcrafter.cth.client.screen.buttons.TabButton;
import creep3rcrafter.cth.client.screen.buttons.TreeButton;
import creep3rcrafter.cth.client.screen.slider.TreeSlider;
import creep3rcrafter.cth.common.ItemManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class TreeScreen extends Screen {
	public static final ResourceLocation RESOURCES = new ResourceLocation("cth", "textures/gui/ui.png");
	public ItemManager itemManager;

	public TreeScreen() {
		super(new TranslationTextComponent("container.Tree"));
		itemManager = new ItemManager();
	}

	@Override
	protected void init() {
		int top = (height - 194) / 2;
		int left = (width - 176) / 2;

		// addButton(new TreeButton(left + 5, top + 30, 158, 32));
		// addButton(new TreeButton(10, -36, 158, 32));

		addButton(new TreeSlider(left + 166, top + 30, 172, 0.5f));

		//addButton(new TabButton(left, top + 30, 32, 28));
		//addButton(new TabButton(left, top + 30 + 28, 32, 28, true));
		// addButton(new TreeButton(left, top+35, 158, 32, itemManager.daggers.get(1),
		// width, height));
		// addButton(new TabButton(left - 28, top, 32, 28));
		for (int i = 0; i < 6; i++) {
			int y = (top + i * 28);
			addButton(new TabButton(left, y + 28, 32, 28));

		}
		

		for (int i = 0; i < 5; i++) {
			int y = (top + i * 35) + 30;
			// addButton(new TreeButton(left + 5, y, 158, 32, itemManager.daggers.get(i),
			// width, height));

		}
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		Minecraft.getInstance().textureManager.bind(RESOURCES);

		int left = (width - 176) / 2;
		int top = (height - 166) / 2;

		renderBackground(stack);
		blit(stack, left, top, 0, 0, 176, 194);
		// blit(stack, left, top+115, 0, 80, 176, 166-80);
		font.draw(stack, title, width / 2 - font.width(title) / 2, top + 6, 0x3F3F3F);

		super.render(stack, mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

	public void renderItemTooltip(MatrixStack mstack, ItemStack stack, int x, int y) {
		renderTooltip(mstack, stack, x, y);
	}

}
