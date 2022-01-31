package creep3rcrafter.cth.common.commands;

import java.util.Collection;

import com.google.common.collect.Multimap;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import creep3rcrafter.cth.CTH;
import creep3rcrafter.cth.common.CTHTags;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;

public class GetCommand {
	static ArgumentBuilder<CommandSource, ?> register()
    {
        return Commands.literal("get")
        		.then(Commands.argument("player", EntityArgument.player())
        		.executes(GetCommand::execute));
    }
	/*
	private static int execute(CommandContext<CommandSource> context) throws CommandSyntaxException
    {
        //ServerPlayerEntity player = EntityArgument.getPlayer(context, "player");
        for (Item item : ForgeRegistries.ITEMS) {
        	if (item instanceof ToolItem) {
        		context.getSource().sendSuccess(new TranslationTextComponent(item.getRegistryName().toString()), true);
        		
        	}
        	if (item instanceof SwordItem) {
    			SwordItem swordItem = (SwordItem)item;
        		context.getSource().sendSuccess(new TranslationTextComponent(swordItem.getRegistryName().toString()+ ", "+ swordItem.getDamage()), true);
        	}
        	if (item instanceof ModifiableItem) {
    			SwordItem swordItem = (SwordItem)item;
        		context.getSource().sendSuccess(new TranslationTextComponent(swordItem.getRegistryName().toString()+ ", "+ swordItem.getDamage()), true);
        	}
        	if (item.is(CTHTags.Items.TOOLS)){
        		context.getSource().sendSuccess(new TranslationTextComponent(item.getRegistryName().toString()), true);
        	}
        }
		return 1;
    }
    */
	private static int execute(CommandContext<CommandSource> context) throws CommandSyntaxException
    {
        //ServerPlayerEntity player = EntityArgument.getPlayer(context, "player");
        for (Item item : ForgeRegistries.ITEMS) {
            NonNullList<ItemStack> variants = NonNullList.create();
            ItemGroup tab = item.getItemCategory();
            if(tab == null)  tab = ItemGroup.TAB_SEARCH;
            item.fillItemCategory(tab, variants);
            for(ItemStack stack : variants) {
            	if (stack.getItem() instanceof SwordItem) {
            		Multimap<Attribute, AttributeModifier> mods = stack.getAttributeModifiers(EquipmentSlotType.MAINHAND);
                    Collection<AttributeModifier> damage_mods = mods.get(Attributes.ATTACK_DAMAGE);
                    
                    if(!damage_mods.isEmpty()) {
                        double damage = 1.0 + damage_mods.stream().filter(m -> m.getOperation() == AttributeModifier.Operation.ADDITION).mapToDouble(AttributeModifier::getAmount).sum();
                        ITextComponent name = stack.getDisplayName();
                        IFormattableTextComponent txt = new StringTextComponent("").append(name).append(", " + damage);
                        context.getSource().sendSuccess(txt, true);
                    }
            	}
            	
            	
                
            }
        }
        return 1;
    }
}
