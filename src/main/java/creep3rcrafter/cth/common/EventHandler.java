package creep3rcrafter.cth.common;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		
	}
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onScroll(GuiScreenEvent.MouseScrollEvent event) {
		scrollOffset = scrollOffset + event.getScrollDelta() * 10;
	}
	

}
