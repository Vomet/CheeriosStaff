package city.ahmeds.CheeriosStaff.listener;

import city.ahmeds.CheeriosStaff.commands.FreezeCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {
	private static FreezeListener instance;

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		FreezeCommand.getInstance().getFrozen();
		if (FreezeCommand.getInstance().getFrozen().contains(p.getUniqueId())) {
			e.setTo(e.getFrom());
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', FreezeCommand.getInstance().getFrozenMessage()));
		}
	}

	public static FreezeListener getInstance() {
		return instance;
	}
}
