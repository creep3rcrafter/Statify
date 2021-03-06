package creep3rcrafter.statify.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;

import creep3rcrafter.statify.client.screen.buttons.TabButton;
import creep3rcrafter.statify.client.screen.buttons.TreeButton;
import creep3rcrafter.statify.client.screen.slider.TreeSlider;
import creep3rcrafter.statify.common.ItemManager;
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

	public TabButton itemsTab;
	public TabButton toolsTab;
	public TabButton weaponsTab;
	public TabButton armorTab;

	public TabButton helmetsTab;
	public TabButton chestplatesTab;
	public TabButton leggingsTab;
	public TabButton bootsTab;
	public TabButton pickaxesTab;
	public TabButton axesTab;
	public TabButton axeWeaponsTab;
	public TabButton shovelsTab;
	public TabButton hoesTab;
	public TabButton swordsTab;
	public TabButton daggersTab;

	public TabButton[] itemsSubTabs;
	public TabButton[] toolsSubTabs;
	public TabButton[] weaponsSubTabs;
	public TabButton[] armorSubTabs;

	public TreeButton[] treebuttons = new TreeButton[5];

	public TreeScreen() {
		super(new TranslationTextComponent("container.Tree"));
		itemManager = new ItemManager();
	}

	@Override
	protected void init() {
		int top = (height - 194) / 2;
		int left = (width - 176) / 2;
		// armor
		helmetsTab = new TabButton(left, top + 28, 32, 28, "Helmets", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(3, 0);
			}
		};
		chestplatesTab = new TabButton(left, top + 56, 32, 28, "Chestplates", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(3, 1);
			}
		};
		leggingsTab = new TabButton(left, top + 84, 32, 28, "Leggings", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(3, 2);
			}
		};
		bootsTab = new TabButton(left, top + 112, 32, 28, "Boots", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(3, 3);
			}
		};
		// tools
		pickaxesTab = new TabButton(left, top + 28, 32, 28, "Pickaxes", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(1, 0);
			}
		};
		axesTab = new TabButton(left, top + 56, 32, 28, "Axes", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(1, 1);
			}
		};
		shovelsTab = new TabButton(left, top + 84, 32, 28, "Shovels", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(1, 2);
			}
		};
		hoesTab = new TabButton(left, top + 112, 32, 28, "Hoes", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(1, 3);
			}
		};
		// weapons
		swordsTab = new TabButton(left, top + 28, 32, 28, "Swords", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(2, 0);
			}
		};
		axeWeaponsTab = new TabButton(left, top + 56, 32, 28, "Axe Weapons", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(2, 2);
			}
		};
		daggersTab = new TabButton(left, top + 84, 32, 28, "Daggers", false) {
			@Override
			public void onPress() {
				setState();
				subTabPressed(2, 1);
			}
		};
		itemsTab = new TabButton(left, top - 10, 32, 28, "Items", true) {
			@Override
			public void onPress() {
				setState();
				tabPressed(0);

			}
		};
		toolsTab = new TabButton(left + 40, top - 10, 32, 28, "Tools", false) {
			@Override
			public void onPress() {
				setState();
				tabPressed(1);
			}
		};
		weaponsTab = new TabButton(left + 80, top - 10, 32, 28, "Weapons", false) {
			@Override
			public void onPress() {
				setState();
				tabPressed(2);
			}
		};
		armorTab = new TabButton(left + 120, top - 10, 32, 28, "Armor", false) {
			@Override
			public void onPress() {
				setState();
				tabPressed(3);
			}
		};
		// tabs
		addButton(itemsTab);
		addButton(toolsTab);
		addButton(weaponsTab);
		addButton(armorTab);

		// subtabs
		// armor
		addButton(helmetsTab);
		helmetsTab.setActive(false);
		addButton(chestplatesTab);
		chestplatesTab.setActive(false);
		addButton(leggingsTab);
		leggingsTab.setActive(false);
		addButton(bootsTab);
		bootsTab.setActive(false);
		// tools
		addButton(pickaxesTab);
		pickaxesTab.setActive(false);
		addButton(axesTab);
		axesTab.setActive(false);
		addButton(shovelsTab);
		shovelsTab.setActive(false);
		addButton(hoesTab);
		hoesTab.setActive(false);
		// weapons
		addButton(swordsTab);
		swordsTab.setActive(false);
		addButton(axeWeaponsTab);
		axeWeaponsTab.setActive(false);
		addButton(daggersTab);
		daggersTab.setActive(false);

		itemsSubTabs = new TabButton[] {};
		toolsSubTabs = new TabButton[] { pickaxesTab, axesTab, shovelsTab, hoesTab };
		weaponsSubTabs = new TabButton[] { swordsTab, daggersTab, axeWeaponsTab };
		armorSubTabs = new TabButton[] { helmetsTab, chestplatesTab, leggingsTab, bootsTab };

		for (int i = 0; i < toolsSubTabs.length; i++) {
			setTooltipOffsets(toolsSubTabs[i]);
		}
		for (int i = 0; i < weaponsSubTabs.length; i++) {
			setTooltipOffsets(weaponsSubTabs[i]);
		}
		for (int i = 0; i < armorSubTabs.length; i++) {
			setTooltipOffsets(armorSubTabs[i]);
		}

		addButton(new TreeSlider(left + 166, top + 30, 172, 0.5f));

		for (int i = 0; i < 5; i++) {
			int y = (top + i * 35) + 30;
			treebuttons[i] = new TreeButton(left + 5, y, 158, 32, itemManager.armor.get(i), width, height);
			addButton(treebuttons[i]);

		}
	}

	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
		Minecraft.getInstance().textureManager.bind(RESOURCES);
		int left = (width - 176) / 2;
		int top = (height - 166) / 2;
		renderBackground(stack);
		blit(stack, left, top, 0, 0, 176, 194);
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

	public void tabPressed(int button) {
		if (button == 0) {// items
			toolsTab.setState(false);
			weaponsTab.setState(false);
			armorTab.setState(false);
			for (int i = 0; i < toolsSubTabs.length; i++) {
				toolsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < weaponsSubTabs.length; i++) {
				weaponsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < armorSubTabs.length; i++) {
				armorSubTabs[i].setActive(false);
			}
		} else if (button == 1) {
			itemsTab.setState(false);
			weaponsTab.setState(false);
			armorTab.setState(false);
			for (int i = 0; i < toolsSubTabs.length; i++) {
				toolsSubTabs[i].setActive(true);
			}
			for (int i = 0; i < weaponsSubTabs.length; i++) {
				weaponsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < armorSubTabs.length; i++) {
				armorSubTabs[i].setActive(false);
			}
			toolsSubTabs[0].setState(true);

		} else if (button == 2) {
			itemsTab.setState(false);
			toolsTab.setState(false);
			armorTab.setState(false);
			for (int i = 0; i < toolsSubTabs.length; i++) {
				toolsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < weaponsSubTabs.length; i++) {
				weaponsSubTabs[i].setActive(true);
			}
			for (int i = 0; i < armorSubTabs.length; i++) {
				armorSubTabs[i].setActive(false);
			}
			weaponsSubTabs[0].setAsActiveTab(true);
		} else if (button == 3) {
			itemsTab.setState(false);
			toolsTab.setState(false);
			weaponsTab.setState(false);
			for (int i = 0; i < toolsSubTabs.length; i++) {
				toolsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < weaponsSubTabs.length; i++) {
				weaponsSubTabs[i].setActive(false);
			}
			for (int i = 0; i < armorSubTabs.length; i++) {
				armorSubTabs[i].setActive(true);
			}
			armorSubTabs[0].setAsActiveTab(true);
		}
	}

	public void subTabPressed(int mainIndex, int index) {
		if (mainIndex == 0) {
			
		} else if (mainIndex == 1) {// tools
			for (int i = 0; i < toolsSubTabs.length; i++) {
				toolsSubTabs[i].setState(false);
			}
			toolsSubTabs[index].setState(true);
			treebuttons[0].setItem(itemManager.tools.get(0));
			treebuttons[1].setItem(itemManager.tools.get(1));
			treebuttons[2].setItem(itemManager.tools.get(2));
			treebuttons[3].setItem(itemManager.tools.get(3));
			treebuttons[4].setItem(itemManager.tools.get(4));
		} else if (mainIndex == 2) {// weapons
			for (int i = 0; i < weaponsSubTabs.length; i++) {
				weaponsSubTabs[i].setState(false);
			}
			weaponsSubTabs[index].setState(true);
			treebuttons[0].setItem(itemManager.weapons.get(0));
			treebuttons[1].setItem(itemManager.weapons.get(1));
			treebuttons[2].setItem(itemManager.weapons.get(2));
			treebuttons[3].setItem(itemManager.weapons.get(3));
			treebuttons[4].setItem(itemManager.weapons.get(4));
		} else if (mainIndex == 3) {// armor
			for (int i = 0; i < armorSubTabs.length; i++) {
				armorSubTabs[i].setState(false);
			}
			armorSubTabs[index].setState(true);
			treebuttons[0].setItem(itemManager.armor.get(0));
			treebuttons[1].setItem(itemManager.armor.get(1));
			treebuttons[2].setItem(itemManager.armor.get(2));
			treebuttons[3].setItem(itemManager.armor.get(3));
			treebuttons[4].setItem(itemManager.armor.get(4));
		}
	}

	public void setTooltipOffsets(TabButton tabButton) {
		int xoffset = -(22 + (5 * tabButton.name.length()));
		tabButton.setTooltipOffset(xoffset, -5);
	}
}
