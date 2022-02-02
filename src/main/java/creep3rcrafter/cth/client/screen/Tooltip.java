package creep3rcrafter.cth.client.screen;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextProperties;
import net.minecraftforge.fml.client.gui.GuiUtils;

public class Tooltip {
	public int width = 0;
	public int height = 0;
	protected FontRenderer font;
	
	public Tooltip(){
		Minecraft minecraft = Minecraft.getInstance();
		this.width = 0;
		this.height = 0;
		font = minecraft.font;
		
	}
	public Tooltip(int width, int height){
		Minecraft minecraft = Minecraft.getInstance();
		this.width = width;
		this.height = height;
		font = minecraft.font;
	}
	public void renderItemTooltip(MatrixStack stack, ItemStack itemstack, int mouseX, int mouseY) {
		FontRenderer font = itemstack.getItem().getFontRenderer(itemstack);
		GuiUtils.preItemToolTip(itemstack);
		this.renderWrappedToolTip(stack, this.getTooltipFromItem(itemstack), mouseX, mouseY,(font == null ? this.font : font));
		GuiUtils.postItemToolTip();
	}

	public void renderWrappedToolTip(MatrixStack matrixStack, List<? extends ITextProperties> tooltips, int mouseX,
			int mouseY, FontRenderer font) {
		GuiUtils.drawHoveringText(matrixStack, tooltips, mouseX, mouseY, width, height, -1, font);
	}

	public List<ITextComponent> getTooltipFromItem(ItemStack itemstack) {
		Minecraft minecraft = Minecraft.getInstance();
		return itemstack.getTooltipLines(minecraft.player,
				minecraft.options.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED
						: ITooltipFlag.TooltipFlags.NORMAL);
	}

}
