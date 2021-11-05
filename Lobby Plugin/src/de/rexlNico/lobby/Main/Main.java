package de.rexlNico.lobby.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.lobby.Addons.AddonManager;

public class Main extends JavaPlugin{

	public static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	@Override
	public void onEnable() {
		plugin = this;
		
		Bukkit.getConsoleSender().sendMessage("§4Lobby geladen");
		AddonManager.LoadAddons();
		
		
	}
	
	public static Main getInstance(){
		return plugin;
	}
	
}
