package creep3rcrafter.cth.common;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.tools.item.small.DaggerTool;
import slimeknights.tconstruct.tools.item.small.HandAxeTool;
import slimeknights.tconstruct.tools.item.small.SwordTool;

public class ItemManager {
	public List<ItemStack> items = new ArrayList<ItemStack>();

	public List<ItemStack> armor = new ArrayList<ItemStack>();
	public List<ItemStack> helmets = new ArrayList<ItemStack>();
	public List<ItemStack> chestplates = new ArrayList<ItemStack>();
	public List<ItemStack> leggings = new ArrayList<ItemStack>();
	public List<ItemStack> boots = new ArrayList<ItemStack>();

	public List<ItemStack> weapons = new ArrayList<ItemStack>();
	public List<ItemStack> swords = new ArrayList<ItemStack>();
	public List<ItemStack> daggers = new ArrayList<ItemStack>();

	public List<ItemStack> tools = new ArrayList<ItemStack>();
	public List<ItemStack> axes = new ArrayList<ItemStack>();
	public List<ItemStack> pickaxes = new ArrayList<ItemStack>();
	public List<ItemStack> shovels = new ArrayList<ItemStack>();
	public List<ItemStack> hoes = new ArrayList<ItemStack>();

	public ItemManager() {
		for (Item item : ForgeRegistries.ITEMS) {
			NonNullList<ItemStack> variants = NonNullList.create();
			ItemGroup tab = item.getItemCategory();
			if (tab == null)
				tab = ItemGroup.TAB_SEARCH;
			item.fillItemCategory(tab, variants);
			
			for (ItemStack stack : variants) {
				if (stack.getItem() instanceof SwordItem) {
					swords.add((ItemStack) stack);
				}
				if (stack.getItem() instanceof SwordTool && !(stack.getItem() instanceof DaggerTool)) {
					swords.add((ItemStack) stack);
				}
				if (stack.getItem() instanceof AxeItem || stack.getItem() instanceof HandAxeTool) {
					axes.add((ItemStack) stack);
				}
				if (stack.getItem() instanceof DaggerTool) {
					daggers.add((ItemStack) stack);
				}
				if (stack.getItem() instanceof ArmorItem) {
					if (MobEntity.getEquipmentSlotForItem(stack) == EquipmentSlotType.HEAD) {
						helmets.add((ItemStack) stack);
					} else if (MobEntity.getEquipmentSlotForItem(stack) == EquipmentSlotType.CHEST) {
						chestplates.add((ItemStack) stack);
					} else if (MobEntity.getEquipmentSlotForItem(stack) == EquipmentSlotType.LEGS) {
						leggings.add((ItemStack) stack);
					} else if (MobEntity.getEquipmentSlotForItem(stack) == EquipmentSlotType.FEET) {
						boots.add((ItemStack) stack);
					}
				}

			}
		}

		weapons.addAll(swords);
		weapons.addAll(daggers);
		weapons.addAll(axes);

		tools.addAll(pickaxes);
		tools.addAll(axes);
		tools.addAll(shovels);
		tools.addAll(hoes);

		armor.addAll(helmets);
		armor.addAll(chestplates);
		armor.addAll(leggings);
		armor.addAll(boots);
		
		items.addAll(tools);
		items.addAll(armor);
		items.addAll(weapons);

		// armor.get(1).getOrCreateTag().putString(null, null);
	}

}
