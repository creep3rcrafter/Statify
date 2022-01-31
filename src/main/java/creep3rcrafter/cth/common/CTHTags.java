package creep3rcrafter.cth.common;

import creep3rcrafter.cth.CTH;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class CTHTags {
	
	public static class Blocks {
		private static Tags.IOptionalNamedTag<Block> createTag(String name){
			return BlockTags.createOptional(new ResourceLocation(CTH.MOD_ID, name));
		}
		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name){
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	public static class Items {

		public static final Tags.IOptionalNamedTag<Item> TOOLS = createTag("tools");
		//public static final Tags.IOptionalNamedTag<Item> SWORDS = createTag("swords");
		//public static final Tags.IOptionalNamedTag<Item> PICKAXES = createTag("pickaxes");
		//public static final Tags.IOptionalNamedTag<Item> AXES = createTag("axes");
		//public static final IOptionalNamedTag<Item> SHOVELS = createTag("shovels");
		//public static final Tags.IOptionalNamedTag<Item> HOES = createTag("hoes");
		
		private static Tags.IOptionalNamedTag<Item> createTag(String name){
			return ItemTags.createOptional(new ResourceLocation(CTH.MOD_ID, name));
		}
		private static Tags.IOptionalNamedTag<Item> createForgeTag(String name){
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
	}

}
