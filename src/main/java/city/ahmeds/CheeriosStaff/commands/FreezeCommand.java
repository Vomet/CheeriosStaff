package city.ahmeds.CheeriosStaff.commands;

import city.ahmeds.CheeriosStaff.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FreezeCommand implements CommandExecutor {
	public Set<UUID> frozen = new HashSet<>();
	String frozenMessage = MainPlugin.getInstance().getConfig().getString("frozen-message");
	String unfrozenMessage = MainPlugin.getInstance().getConfig().getString("frozen-message");
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player target = Bukkit.getPlayer(args[0]);
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (sender instanceof Player) {
				if (args.length == 1) {
					if (frozen.contains(target.getUniqueId())) {
						target.
					}
				}
			}

		}
		return true;
	}


	}

