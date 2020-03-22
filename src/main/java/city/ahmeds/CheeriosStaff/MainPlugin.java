package city.ahmeds.CheeriosStaff;

import city.ahmeds.CheeriosStaff.commands.FreezeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MainPlugin extends JavaPlugin {
	private static MainPlugin instance;

	@Override
	public void onEnable() {
		instance = this;
		System.out.println(ChatColor.translateAlternateColorCodes('&', "\n&f--------------------\n&cCheerios&fStaff has been enabled\n&f--------------------\n"));
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			getLogger().info("Config.yml not found, creating!");
			saveDefaultConfig();
		} else {
			getLogger().info("Config.yml found, loading!");
		}
		Bukkit.getServer().getPluginManager().registerEvents(new FreezeCommand.FreezeListener(), this);

	}

	private void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				getLogger().info("Config.yml not found, creating!");
				saveDefaultConfig();
			} else {
				getLogger().info("Config.yml found, loading!");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


	@Override
	public void onDisable() {
		instance = null;
		System.out.println(ChatColor.translateAlternateColorCodes('&', "\n&f--------------------\n&cCheerios&fStaff has been disabled\n&f--------------------\n"));
	}

	public static MainPlugin getInstance() {
		return instance;
	}
}
