package city.ahmeds.CheeriosStaff.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (frozen.contains(p.getUniqueId())) {
			e.setTo(e.getFrom());
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', frozenMessage));
		}
	}
