package city.ahmeds.CheeriosStaff.commands;

import city.ahmeds.CheeriosStaff.MainPlugin;
import city.ahmeds.CheeriosStaff.listener.MuteChatListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteChatCommand implements CommandExecutor {
	private MuteChatListener muteListener = new MuteChatListener();
	String unmutedMsg = MainPlugin.getInstance().getConfig().getString("unmuted-chat-message");
	String mutedMsg = MainPlugin.getInstance().getConfig().getString("muted-chat-message");
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check what command was just typed
		if (cmd.getName().equalsIgnoreCase("mutechat")) {
			// Invert the chatEnabled boolean to the opposite
			muteListener.chatEnabled = !muteListener.chatEnabled;
			// See if the chatEnabled boolean is true if it is print the string 'Unmuted the chat' if not then 'Muted the chat'
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',muteListener.chatEnabled ? unmutedMsg : mutedMsg));
		}
		// Return true always since there is no actual usage other than the name of the command.
		return true;
	}
}
