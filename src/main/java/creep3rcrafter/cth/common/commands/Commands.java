package creep3rcrafter.cth.common.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Commands {
	
	@SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event)
    {
        event.getDispatcher().register(
            LiteralArgumentBuilder.<CommandSource>literal("cth")
            .requires(source -> source.hasPermission(2))
            .then(GetCommand.register())
            .then(OpenTreeCommand.register()));
    }

}
