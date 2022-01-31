package creep3rcrafter.cth.common;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		
	}

}
