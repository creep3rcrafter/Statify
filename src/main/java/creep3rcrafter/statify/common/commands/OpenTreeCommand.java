package creep3rcrafter.statify.common.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import creep3rcrafter.statify.client.screen.TreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
public class OpenTreeCommand {
	static ArgumentBuilder<CommandSource, ?> register()
    {
        return Commands.literal("open").executes(OpenTreeCommand::execute);
    }
	private static int execute(CommandContext<CommandSource> context) throws CommandSyntaxException
    {
        Minecraft minecraft = Minecraft.getInstance();
		minecraft.setScreen(new TreeScreen());
        return 1;
    }

}
