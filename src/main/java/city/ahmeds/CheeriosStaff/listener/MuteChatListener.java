package city.ahmeds.CheeriosStaff.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteChatListener implements Listener {
	public volatile boolean chatEnabled = true;

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		if (!chatEnabled) {
			event.setCancelled(true);
		}
	}
}
