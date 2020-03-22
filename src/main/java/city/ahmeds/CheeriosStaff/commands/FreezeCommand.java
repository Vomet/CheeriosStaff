package city.ahmeds.CheeriosStaff.commands;

import city.ahmeds.CheeriosStaff.MainPlugin;
import city.ahmeds.CheeriosStaff.listener.FreezeListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FreezeCommand implements CommandExecutor {
	private static FreezeCommand instance;
	private Set<UUID> frozen = new HashSet<>();
	String frozenMessage = MainPlugin.getInstance().getConfig().getString("frozen-message");
	String unfrozenMessage = MainPlugin.getInstance().getConfig().getString("unfrozen-message");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (sender instanceof Player) {

				Player p = (Player) sender;
				if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (frozen.contains(target.getUniqueId())) {
						frozen.remove(target.getUniqueId());
						target.sendMessage(unfrozenMessage);
					} else if (!frozen.contains(target.getUniqueId())) {
						FreezeListener.getInstance().onPlayerMove((PlayerMoveEvent) target);
						target.sendMessage(frozenMessage);
					}
				}
			}

		}
		return true;
	}

	public Set<UUID> getFrozen() {
		return frozen;
	}

	public static FreezeCommand getInstance() {
		return instance;
	}

	public String getFrozenMessage() {
		return frozenMessage;
	}

	public String getUnfrozenMessage() {
		return unfrozenMessage;
	}
}

