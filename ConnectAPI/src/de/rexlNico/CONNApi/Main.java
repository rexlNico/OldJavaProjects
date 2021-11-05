package de.rexlNico.CONNApi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Main {

	private Main plugin;
	
	private void onEnable() {
		plugin = this;
		
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel((Plugin) this, "BungeeCord");
		
	}
	
	public Main getPlugin() {
		return plugin;
	}
	
}
